package com.ceiba.planta;

import com.ceiba.planta.comando.ComandoPlanta;
import com.ceiba.planta.modelo.entidad.CategoriaPlanta;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PlantaTestDataBuilderComando {

    private int idPlanta;
    private String nombre;
    private String descripcion;
    private LocalDate fechaIngreso;
    private int cantidad;
    private BigDecimal valor;
    private CategoriaPlanta categoria;


    public PlantaTestDataBuilderComando(){
        this.idPlanta =1;
        this.nombre ="manzanilla";
        this.descripcion="planta aromatica";
        this.fechaIngreso =LocalDate.now();
        this.cantidad = 25;
        this.valor = new BigDecimal(8000);
        this.categoria = CategoriaPlanta.valueOf("AROMATICASYMEDICINALES");
    }

    public ComandoPlanta build(){return new ComandoPlanta(idPlanta, nombre, descripcion, fechaIngreso, cantidad, valor, categoria); }

}
