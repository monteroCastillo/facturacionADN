package com.ceiba.proveedor;

import com.ceiba.proveedor.modelo.entidad.Proveedor;

public class SolicitudProveedorTestDataBuilder {

    private Long id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String paginaWeb;


    public SolicitudProveedorTestDataBuilder conProveedorPorDefecto(){
        this.id = 1l;
        this.nombre = "Proveedor 1";
        this.direccion = "Av 4";
        this.telefono = "55555";
        this.paginaWeb ="proveedor.com.co";
        return this;
    }

    public SolicitudProveedorTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public SolicitudProveedorTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public SolicitudProveedorTestDataBuilder conDireccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    public SolicitudProveedorTestDataBuilder conTelefono(String telefono) {
        this.telefono = telefono;
        return this;
    }

    public SolicitudProveedorTestDataBuilder conPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
        return this;
    }
    public Proveedor reconstruir() {
        return Proveedor.reconstruir(id, nombre, direccion, telefono, paginaWeb);
    }

}

