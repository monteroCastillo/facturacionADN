package com.ceiba.proveedor.modelo.entidad;

import com.ceiba.dominio.ValidadorArgumento;

public class Proveedor {
    private Long id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String paginaWeb;

    public Proveedor() {
    }

    public Proveedor(Long id, String nombre, String direccion, String telefono, String paginaWeb) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.paginaWeb = paginaWeb;
    }

    public static Proveedor reconstruir(Long id, String nombre, String direccion, String telefono, String paginaWeb ){
        ValidadorArgumento.validarObligatorio(id, "El id del proveedor es requerido");
        ValidadorArgumento.validarObligatorio(nombre, "el nombre del proveedor es requerido");
        ValidadorArgumento.validarObligatorio(direccion, "La direccion del proveedor es requerida");
        ValidadorArgumento.validarObligatorio(telefono, "El telefono del proveedor es requerido");
        ValidadorArgumento.validarObligatorio(paginaWeb, "La pagina web del proveedor es requerida");

        return new Proveedor(id, nombre, direccion, telefono, paginaWeb);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }
}
