package com.ceiba.persona.modelo.entidad;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Persona {

    @Id
    private long idPersona;
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

    public void setIdPersona(final long idPersona) {
        this.idPersona = idPersona;
    }

    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(final String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(final String telefono) {
        this.telefono = telefono;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public void setFechaRegistro(final LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
