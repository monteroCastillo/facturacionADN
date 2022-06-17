package com.ceiba.Empleado.modelo.entidad;

import com.ceiba.dominio.ValidadorArgumento;


import java.time.LocalDate;
public class Empleado {
    private Long idEmpleado;
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
    private LocalDate fechaRegistro;
    private Perfil perfil;

    public Empleado() {
    }

    public Empleado(long idEmpleado, String nombre, String direccion, String telefono, String email, LocalDate fechaRegistro, Perfil perfil) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.fechaRegistro = fechaRegistro;
        this.perfil = perfil;
    }
    public static Empleado reconstruir(Long idEmpleado, String nombre, String direccion, String telefono, String email, LocalDate fechaRegistro, Perfil perfil) {
        ValidadorArgumento.validarObligatorio(idEmpleado, "El id de la persona es requerido");
        ValidadorArgumento.validarObligatorio(nombre, "El nombre de la persona es requerido");
        ValidadorArgumento.validarObligatorio(direccion, "La direccion de la persoan es requerida");
        ValidadorArgumento.validarObligatorio(telefono, "El telefono de la persona es requerido");
        ValidadorArgumento.validarObligatorio(email, "El email de la persona es requerido");
        ValidadorArgumento.validarObligatorio(fechaRegistro, "La fecha de registro es requerida");
        ValidadorArgumento.validarObligatorio(perfil, "La fecha de registro es requerida");
        return new Empleado(idEmpleado, nombre, direccion, telefono, email, fechaRegistro, perfil);
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public long getIdEmpleado() {
        return this.idEmpleado;
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

    public void setIdEmpleado(long idEmpleado) {
        this.idEmpleado = idEmpleado;
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
