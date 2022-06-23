package com.ceiba.factura.modelo.entidad;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.dominio.ValidadorArgumento;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.factura.utils.HolidayUtil;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Factura {

    public static final double DESCUENTO_CLIENTE_PREFERENCIAL = 0.2;
    public static final double DESCUENTO_CLIENTE_ESPECIAL = 0.1;

    public static final double COBRO_ADICIONAL_FESTIVO = 0.15;
    private Long id;
    private Cliente cliente;
    private List<ProductoFacturar> productosFacturar;
    private BigDecimal valorTotal;
    private EstadoFactura estado;
    private LocalDate fechaIngreso;
    private LocalDate fechaDomicilio;

//    public Factura(Long id, Cliente cliente, List<ProductoFacturar> productosFacturar, BigDecimal valorTotal, EstadoFactura estado, LocalDate fechaIngreso) {
//        this.id = id;
//        this.cliente = cliente;
//        this.productosFacturar = productosFacturar;
//        this.valorTotal = valorTotal;
//        this.estado = estado;
//        this.fechaIngreso = fechaIngreso;
//    }

    private Factura(LocalDate fechaIngreso, Cliente cliente, List<ProductoFacturar> productosFacturar ) {
        this.cliente = cliente;
        this.productosFacturar = new ArrayList<>(productosFacturar);
        this.valorTotal = calcularvalorTotal(productosFacturar);
        aplicarDescuento();
        this.estado = EstadoFactura.ACTIVA;
        this.fechaIngreso = fechaIngreso;
        validarDiaFestivo(fechaIngreso);
        this.fechaDomicilio = validarSiguienteDiaHabil(fechaIngreso);

    }
    private Factura(Long id, Cliente cliente, List<ProductoFacturar> productosFacturar, BigDecimal valorTotal, EstadoFactura estadoFactura, LocalDate fechaIngreso, LocalDate fechaDomicilio) {
        this.cliente = cliente;
        this.productosFacturar = new ArrayList<>(productosFacturar);
        this.id = id;
        this.valorTotal = valorTotal;
        this.estado = estadoFactura;
        this.fechaIngreso = fechaIngreso;
        this.fechaDomicilio = fechaDomicilio;

    }

    private BigDecimal calcularvalorTotal(List<ProductoFacturar> productosFacturar) {
        return productosFacturar.stream()
                .map(ProductoFacturar::calcularTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private void aplicarDescuento() {
        if (this.cliente.esTipoPreferencial()) {
            this.valorTotal = valorTotal.subtract(valorTotal.multiply(BigDecimal.valueOf(DESCUENTO_CLIENTE_PREFERENCIAL)));
        } else if (this.cliente.esTipoEspecial()) {
            this.valorTotal = valorTotal.subtract(valorTotal.multiply(BigDecimal.valueOf(DESCUENTO_CLIENTE_ESPECIAL)));
        }
    }

    public void anular() {
        if(this.cliente.esTipoComun()){
            throw new ExcepcionValorInvalido("No se puede anular la factura de un cliente comun");
        }
        this.estado = EstadoFactura.ANULADA;
    }

    public void validarDiaFestivo(LocalDate fecha){
        var anio = fecha.getYear();
        var mes = fecha.getMonthValue();
        var dia = fecha.getDayOfMonth();

        if(  new HolidayUtil(anio).isHoliday(mes-1, dia)) {
            this.valorTotal = valorTotal.add(valorTotal.multiply(BigDecimal.valueOf(COBRO_ADICIONAL_FESTIVO)));
        }
    }

    public LocalDate validarSiguienteDiaHabil(LocalDate fecha){
        var anio = fecha.getYear();

        Date fecha2 = java.sql.Date.valueOf(fecha);

        Date respuesta = new HolidayUtil(anio).getNextBusinessDay(fecha2,1);

        return  respuesta.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public List<ProductoFacturar> getProductos() {
        return Collections.unmodifiableList(productosFacturar);
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public Long getId() {
        return id;
    }

    public static Factura crear(SolicitudFacturar solicitudFacturar) {
        ValidadorArgumento.validarObligatorio(solicitudFacturar.getFechaIngreso(), "No se puede crear una factura sin fecha ");
        ValidadorArgumento.validarObligatorio(solicitudFacturar.getCliente(), "El cliente es requerido para facturar");
        ValidadorArgumento.validarObligatorio(solicitudFacturar.getProductosFacturar(), "No se puede crear una factura sin productos");
        return new Factura(solicitudFacturar.getFechaIngreso(), solicitudFacturar.getCliente(), solicitudFacturar.getProductosFacturar());
    }

    public static Factura reconstruir(Long id, Cliente cliente, List<ProductoFacturar> productosFacturar, BigDecimal valorTotal, EstadoFactura estadoFactura, LocalDate fechaIngreso, LocalDate fechaDomicilio) {
        ValidadorArgumento.validarObligatorio(cliente, "El cliente es requerido para facturar");
        ValidadorArgumento.validarObligatorio(productosFacturar, "No se puede crear una factura sin productos");
        ValidadorArgumento.validarObligatorio(id, "El id es requerido");
        if (valorTotal.compareTo(BigDecimal.ZERO) <= 0) {
            throw new ExcepcionValorInvalido("El total no puede ser menor a cero");
        }
        ValidadorArgumento.validarObligatorio(fechaIngreso, "La fecha de ingreso es requerida");
        ValidadorArgumento.validarObligatorio(fechaDomicilio, "La fecha de domicilio es requerida");

        return new Factura(id, cliente, productosFacturar, valorTotal, estadoFactura, fechaIngreso, fechaDomicilio);
    }


    public Boolean esAnulada() {
        return this.estado.equals(EstadoFactura.ANULADA);
    }

    public boolean esActiva() {
        return this.estado.equals(EstadoFactura.ACTIVA);
    }

    public EstadoFactura getEstado() {
        return estado;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public LocalDate getFechaDomicilio() {
        return fechaDomicilio;
    }

    public void setFechaDomicilio(LocalDate fechaDomicilio) {
        this.fechaDomicilio = fechaDomicilio;
    }
}
