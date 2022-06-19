package com.ceiba.Proveedor.controlador.testDataBuilder;

import com.ceiba.proveedor.modelo.entidad.Proveedor;

public class ComandoProveedorTestDataBuilder {
    private Long id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String paginaWeb;


    public ComandoProveedorTestDataBuilder() {
        this.id = 22l;
        this.nombre ="plantas y plantas";
        this.direccion = "Av vasquez Cobo";
        this.telefono = "5656565";
        this.paginaWeb = "plantasyplantas.com.co";

    }

    public Proveedor build() {
        return new Proveedor(id,nombre, direccion, telefono,paginaWeb);}
}
