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
        this.idPlanta = 1;
        this.nombre = "rosa";
        this.descripcion = "flor roja";
        this.fechaIngreso = LocalDate.of(2022,06,22);
        this.cantidad = 50;
        this.valor = new BigDecimal(5000);
        this.categoria = CategoriaPlanta.PLANTASDEFLOR;
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
    public Planta build( ) {
        return new Planta(idPlanta, nombre, descripcion, fechaIngreso, cantidad, valor, categoria);
    }

}
