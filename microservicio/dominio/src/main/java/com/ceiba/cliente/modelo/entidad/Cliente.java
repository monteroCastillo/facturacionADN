package com.ceiba.cliente.modelo.entidad;

import com.ceiba.dominio.ValidadorArgumento;

public class Cliente {

    private Long id;
    private  String nombre;
    private  String direccion;
    private  String telefono;
    private  String email;
    private  TipoCliente tipoCliente;

    public Cliente(Long id, String nombre, String direccion, String telefono, String email, TipoCliente tipoCliente) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.tipoCliente = tipoCliente;
    }

    public static Cliente reconstruir(Long id, String nombre, String direccion, String telefono, String email, TipoCliente tipoCliente) {
        ValidadorArgumento.validarObligatorio(direccion, "La direccion es requerido");
        ValidadorArgumento.validarObligatorio(nombre, "Nombre del cliente es requerido");
        ValidadorArgumento.validarObligatorio(id, "Id del cliente es requerido");
        ValidadorArgumento.validarObligatorio(telefono, "El telefono del cliente es requerido");
        ValidadorArgumento.validarObligatorio(email, "El Email  del cliente es requerido");
        ValidadorArgumento.validarObligatorio(tipoCliente, "Tipo de cliente es requerido");
        return new Cliente(id, nombre, direccion, telefono, email, tipoCliente);
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

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public boolean esTipoPreferencial() {
        return this.tipoCliente.equals(TipoCliente.PREFERENCIAL);
    }

    public boolean esTipoEspecial() {
        return this.tipoCliente.equals(TipoCliente.ESPECIAL);
    }

    public boolean esTipoComun() {
        return this.tipoCliente.equals(TipoCliente.COMUN);
    }
}
