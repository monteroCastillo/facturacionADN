package com.ceiba.factura;

import com.ceiba.factura.modelo.entidad.ProductoFacturar;
import com.ceiba.planta.modelo.entidad.Planta;

public class ProductoFacturarTestDataBuilder {
    private Integer cantidad;
    private Planta planta;
    private Long id;

    public ProductoFacturarTestDataBuilder conCantidad(Integer cantidad) {
        this.cantidad = cantidad;
        return this;
    }

    public ProductoFacturarTestDataBuilder conPlanta(Planta planta) {
        this.planta = planta;
        return this;
    }

    public ProductoFacturarTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ProductoFacturar build() {
        return ProductoFacturar.crear(cantidad, planta);
    }

    public ProductoFacturar reconstruir() {
        return ProductoFacturar.reconstruir(id, cantidad, planta);
    }
}
