package com.ceiba.cliente.modelo.entidad;

import com.ceiba.dominio.ValidadorArgumento;
@SuppressWarnings("java:S2974")
public class Cliente {

    private Long id;
    private  String nombre;
    private  String direccion;
    private  String telefono;
    private  String email;
    private  TipoCliente tipoCliente;

    private Cliente(Long id, String nombre, String direccion, String telefono, String email, TipoCliente tipoCliente) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.tipoCliente = tipoCliente;
    }

    public static Cliente reconstruir(Long id, String nombre, String direccion, String telefono, String email, TipoCliente tipoCliente) {
        ValidadorArgumento.validarObligatorio(id, "Id del cliente es requerido");
        ValidadorArgumento.validarObligatorio(nombre, "Nombre del cliente es requerido");
        ValidadorArgumento.validarObligatorio(direccion, "La direccion es requerido");
        ValidadorArgumento.validarObligatorio(telefono, "El telefono del cliente es requerido");
        ValidadorArgumento.validarObligatorio(email, "El Email  del cliente es requerido");
        ValidadorArgumento.validarObligatorio(tipoCliente, "Tipo de cliente es requerido");
        return new Cliente(id, nombre, direccion, telefono, email, tipoCliente);
    }

    public static Cliente crear(SolicitudCrearCliente solicitudCrearCliente){
        ValidadorArgumento.validarObligatorio(solicitudCrearCliente.getNombre(), "Nombre del cliente es requerido");
        ValidadorArgumento.validarObligatorio(solicitudCrearCliente.getDireccion(), "La direccion es requerido");
        ValidadorArgumento.validarObligatorio(solicitudCrearCliente.getTelefono(), "El telefono del cliente es requerido");
        ValidadorArgumento.validarObligatorio(solicitudCrearCliente.getEmail(), "El Email  del cliente es requerido");
        ValidadorArgumento.validarObligatorio(solicitudCrearCliente.getTipoCliente(), "Tipo de cliente es requerido");
        return new Cliente(solicitudCrearCliente.getId(), solicitudCrearCliente.getNombre(),solicitudCrearCliente.getDireccion(),
                solicitudCrearCliente.getTelefono(), solicitudCrearCliente.getEmail(), solicitudCrearCliente.getTipoCliente());
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
