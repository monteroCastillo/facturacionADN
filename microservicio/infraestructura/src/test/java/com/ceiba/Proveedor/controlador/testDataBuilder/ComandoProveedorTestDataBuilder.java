package com.ceiba.Proveedor.controlador.testDataBuilder;

public class ComandoProveedorTestDataBuilder {
    private Long id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String paginaWeb;


    public ComandoProveedorTestDataBuilder() {
        this.id = 1l;
        this.nombre ="plantas y plantas";
        this.direccion = "Av 4";
        this.telefono = "2747258";
        this.paginaWeb = "plantasyplantas.com.co";

    }

    public ComandoProveedorTestDataBuilder build() {
        return new ComandoProveedorTestDataBuilder(id, nombre, direccion, telefono, paginaWeb);
    }
}
