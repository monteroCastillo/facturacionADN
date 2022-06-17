package com.ceiba.planta.modelo.entidad;

import com.ceiba.dominio.ValidadorArgumento;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.ToString;
import java.time.LocalDate;
@AllArgsConstructor
@Builder
@ToString
public class Planta {


    private int idPlanta;
    private String nombre;
    private String descripcion;
    private LocalDate fechaIngreso;

    private int cantidad;

    private CategoriaPlanta categoria;

    public Planta() {

    }

    public static Planta reconstruir(int idPlanta, String nombre, String descripcion, LocalDate fechaIngreso,int cantidad,CategoriaPlanta categoria){
        ValidadorArgumento.validarObligatorio(idPlanta, "El id de la planta es requerido");
        ValidadorArgumento.validarObligatorio(nombre, "El nombre de la planta es requerido");
        ValidadorArgumento.validarObligatorio(descripcion, "La descripcion de la planta es requerida");
        ValidadorArgumento.validarObligatorio(fechaIngreso, "La fecha de ingreso de la planta es requerida");
        ValidadorArgumento.validarObligatorio(cantidad, "La cantidad de plantas es requerida");
        ValidadorArgumento.validarObligatorio(categoria, "La categoria de la planta es requerida");
        return new Planta(idPlanta, nombre, descripcion,fechaIngreso,cantidad, categoria);
    }


    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public CategoriaPlanta getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaPlanta categoria) {
        this.categoria = categoria;
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
