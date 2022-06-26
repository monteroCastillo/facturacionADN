package com.ceiba.Proveedor;

import com.ceiba.proveedor.modelo.entidad.Proveedor;

public class ComandoProveedorTestDataBuilder {
    private Long id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String paginaWeb;

    public ComandoProveedorTestDataBuilder crearPorDefecto() {
        this.id = 1L;
        this.nombre ="plantas y plantas";
        this.direccion = "Av vasquez Cobo";
        this.telefono = "5656565";
        this.paginaWeb = "plantasyplantas.com.co";
        return this;
    }

    public Proveedor build() {
        return new Proveedor(id, nombre, direccion, telefono, paginaWeb);
    }
}
