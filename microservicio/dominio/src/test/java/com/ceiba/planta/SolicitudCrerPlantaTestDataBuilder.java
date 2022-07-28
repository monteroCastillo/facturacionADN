package com.ceiba.planta;

import com.ceiba.planta.modelo.entidad.CategoriaPlanta;
import com.ceiba.planta.modelo.entidad.Planta;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SolicitudCrerPlantaTestDataBuilder {
    private Long id;
    private String nombre;
    private String descripcion;
    private LocalDate fechaIngreso;
    private int cantidad;
    private BigDecimal valor;
    private CategoriaPlanta categoria;

    public SolicitudCrerPlantaTestDataBuilder conPlantaPorDefecto() {
        this.id = 1l;
        this.nombre = "rosa";
        this.descripcion = "flor roja";
        this.fechaIngreso = LocalDate.of(2022,06,22);
        this.cantidad = 50;
        this.valor = new BigDecimal(5000);
        this.categoria = CategoriaPlanta.PLANTASDEFLOR;
        return this;
    }


    public SolicitudCrerPlantaTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public SolicitudCrerPlantaTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public SolicitudCrerPlantaTestDataBuilder conDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public SolicitudCrerPlantaTestDataBuilder conFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
        return this;
    }

    public SolicitudCrerPlantaTestDataBuilder conCantidad(int cantidad) {
        this.cantidad = cantidad;
        return this;
    }

    public SolicitudCrerPlantaTestDataBuilder conValor(BigDecimal valor ) {
        this.valor = valor;
        return this;
    }

    public SolicitudCrerPlantaTestDataBuilder conCategoria(CategoriaPlanta categoria) {
        this.categoria = categoria;
        return this;
    }

    public Planta reconstruir() {
        return Planta.reconstruir(id, nombre, descripcion, fechaIngreso, cantidad, valor, categoria);
    }

}