package com.ceiba.persona.modelo.entidad;

import com.ceiba.dominio.ValidadorArgumento;
import com.ceiba.producto.entidad.Producto;


import java.math.BigDecimal;
import java.time.LocalDate;
public class Persona {


    private Long idPersona;
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
    private LocalDate fechaRegistro;

    public Persona() {
    }

    public Persona(long idPersona, String nombre, String direccion, String telefono, String email, LocalDate fechaRegistro) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.fechaRegistro = fechaRegistro;
    }
    public Persona(long idPersona, String nombre, String direccion, String telefono) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }



    public static Persona reconstruir(Long idPersona, String nombre, String direccion, String telefono) {
        ValidadorArgumento.validarObligatorio(idPersona, "El id de la persona es requerido");
        ValidadorArgumento.validarObligatorio(nombre, "El nombre de la persona es requerido");
        ValidadorArgumento.validarObligatorio(direccion, "La direccion de la persoan es requerida");
        ValidadorArgumento.validarObligatorio(telefono, "El telefono de la persona es requerido");
        return new Persona(idPersona, nombre, direccion, telefono);
    }

    public static Persona reconstruir(Long idPersona, String nombre, String direccion, String telefono, String email, LocalDate fechaRegistro) {
        ValidadorArgumento.validarObligatorio(idPersona, "El id de la persona es requerido");
        ValidadorArgumento.validarObligatorio(nombre, "El nombre de la persona es requerido");
        ValidadorArgumento.validarObligatorio(direccion, "La direccion de la persoan es requerida");
        ValidadorArgumento.validarObligatorio(telefono, "El telefono de la persona es requerido");
        ValidadorArgumento.validarObligatorio(email, "El email de la persona es requerido");
        ValidadorArgumento.validarObligatorio(fechaRegistro, "La fecha de registro es requerida");
        return new Persona(idPersona, nombre, direccion, telefono, email, fechaRegistro);
    }
    public long getIdPersona() {
        return this.idPersona;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public String getEmail() {
        return this.email;
    }

    public LocalDate getFechaRegistro() {
        return this.fechaRegistro;
    }

    public void setIdPersona(long idPersona) {
        this.idPersona = idPersona;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFechaRegistro(final LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
