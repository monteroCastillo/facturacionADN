package com.ceiba.planta;

import com.ceiba.planta.modelo.entidad.CategoriaPlanta;
import com.ceiba.planta.modelo.entidad.Planta;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PlantaTestDataBuilder {
    private int idPlanta;
    private String nombre;
    private String descripcion;
    private LocalDate fechaIngreso;
    private int cantidad;

    private  BigDecimal valor;
    private CategoriaPlanta categoria;

    public PlantaTestDataBuilder conPlantaPorDefecto() {
        this.idPlanta = idPlanta;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaIngreso = fechaIngreso;
        this.cantidad = cantidad;
        this.valor = valor;
        this.categoria = categoria;
        return this;
    }

    public Planta reconstruir() {
        return Planta.reconstruir(idPlanta, nombre, descripcion, fechaIngreso, cantidad, valor, categoria);
    }

    public PlantaTestDataBuilder conId(int idPlanta) {
        this.idPlanta = idPlanta;
        return this;
    }

    public PlantaTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public PlantaTestDataBuilder conDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public PlantaTestDataBuilder conFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
        return this;
    }

    public PlantaTestDataBuilder conCantidad(int cantidad) {
        this.cantidad = cantidad;
        return this;
    }

    public PlantaTestDataBuilder conValor(BigDecimal valor ) {
        this.valor = valor;
        return this;
    }

    public PlantaTestDataBuilder conCategoria(CategoriaPlanta categoria) {
        this.categoria = categoria;
        return this;
    }

}
