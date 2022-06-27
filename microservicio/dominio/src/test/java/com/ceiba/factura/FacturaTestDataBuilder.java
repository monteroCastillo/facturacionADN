package com.ceiba.factura;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.factura.modelo.entidad.EstadoFactura;
import com.ceiba.factura.modelo.entidad.Factura;
import com.ceiba.factura.modelo.entidad.ProductoFacturar;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FacturaTestDataBuilder {
    private Long id;
    private Cliente cliente;
    private List<ProductoFacturar> productosFacturar;
    private BigDecimal valorTotal;
    private EstadoFactura estadoFactura;
    private LocalDate fechaIngreso;
    private LocalDate fechaDomicilio;


    public FacturaTestDataBuilder() {
        productosFacturar = new ArrayList<>();
    }
    public FacturaTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public FacturaTestDataBuilder conCliente(Cliente cliente) {
        this.cliente = cliente;
        return this;
    }

    public FacturaTestDataBuilder conProducto(ProductoFacturar productoFacturar) {
        this.productosFacturar.add(productoFacturar);
        return this;
    }

    public FacturaTestDataBuilder conProductos(List<ProductoFacturar> productosFacturar) {
        this.productosFacturar = productosFacturar;
        return this;
    }

    public FacturaTestDataBuilder conValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
        return this;
    }

    public FacturaTestDataBuilder conEstado(EstadoFactura estadoFactura) {
        this.estadoFactura = estadoFactura;
        return this;
    }
    public FacturaTestDataBuilder conFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
        return this;
    }
    public FacturaTestDataBuilder conFechaDomicilio(LocalDate fechaDomicilio) {
        this.fechaDomicilio = fechaDomicilio;
        return this;
    }


    public Factura reconstruir() {
        return Factura.reconstruir(id, cliente, productosFacturar, valorTotal, estadoFactura, fechaIngreso, fechaDomicilio);
    }
}
