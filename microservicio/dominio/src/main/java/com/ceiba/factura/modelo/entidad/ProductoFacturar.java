package com.ceiba.factura.modelo.entidad;

import com.ceiba.dominio.ValidadorArgumento;
import com.ceiba.planta.modelo.entidad.Planta;
import com.ceiba.producto.entidad.Producto;

import java.math.BigDecimal;

public class ProductoFacturar {
    public static final Double VALOR_IVA = 0.19;

    private Long id;
    private final Integer cantidad;
    private final Planta planta;

    private ProductoFacturar(Integer cantidad, Planta planta) {
        this.cantidad = cantidad;
        this.planta = planta;
    }

    private ProductoFacturar(Long id, Integer cantidad, Planta planta) {
        this.cantidad = cantidad;
        this.planta = planta;
        this.id = id;
    }

    public static ProductoFacturar crear(Integer cantidad, Planta planta) {
        ValidadorArgumento.validarObligatorio(cantidad, "Cantidad es requerida");
        ValidadorArgumento.validarObligatorio(planta, "Producto es requerido");
        return new ProductoFacturar(cantidad, planta);
    }

    public static ProductoFacturar reconstruir(Long id, Integer cantidad, Planta planta) {
        ValidadorArgumento.validarObligatorio(cantidad, "Cantidad es requerida");
        ValidadorArgumento.validarObligatorio(planta, "Planta es requerido");
        return new ProductoFacturar(id, cantidad, planta);
    }

    private BigDecimal calcularSubTotal() {
        return planta.getValor()
                .multiply(BigDecimal.valueOf(cantidad));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public Planta getPlanta() {
        return planta;
    }
}
