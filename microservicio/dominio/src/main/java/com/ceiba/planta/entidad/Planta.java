package com.ceiba.planta.entidad;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;


@AllArgsConstructor
@Builder
@ToString

public class Planta {

    @Id

    private int idPlanta;
    private String nombre;
    private String descripcion;
    private LocalDate fechaIngreso;

    public Planta() {

    }

    public static Planta reconstruir(int idPlanta, String nombre, String descripcion, LocalDate fechaIngreso){
        return new Planta(idPlanta, nombre, descripcion,fechaIngreso);
    }

    public int getIdPlanta() {
        return idPlanta;
    }

    public void setIdPlanta(int idPlanta) {
        this.idPlanta = idPlanta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
}
