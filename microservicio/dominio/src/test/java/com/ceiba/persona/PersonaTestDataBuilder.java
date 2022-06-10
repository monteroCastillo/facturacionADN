package com.ceiba.persona;



import com.ceiba.persona.modelo.entidad.Persona;

import java.time.LocalDate;

public class PersonaTestDataBuilder {
    private Long idPersona;
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
    private LocalDate fechaRegistro;



    public PersonaTestDataBuilder conPersonaPorDefecto() {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        return this;
    }


    public Persona reconstruir() {
        return Persona.reconstruir(idPersona, nombre, direccion, telefono);
    }

    public PersonaTestDataBuilder conId(Long idPersona) {
        this.idPersona = idPersona;
        return this;
    }

    public PersonaTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public PersonaTestDataBuilder conDireccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    public PersonaTestDataBuilder conTelefono(String telefono) {
        this.telefono = telefono;
        return this;
    }

    public PersonaTestDataBuilder conEmail(String Email) {
        this.email = email;
        return this;
    }

    public PersonaTestDataBuilder conFechaRegistro(String FechaRegistro) {
        this.fechaRegistro = fechaRegistro;
        return this;
    }


}
