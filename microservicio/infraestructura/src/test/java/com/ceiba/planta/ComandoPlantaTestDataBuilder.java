package com.ceiba.planta;

import com.ceiba.planta.modelo.entidad.CategoriaPlanta;
import com.ceiba.planta.modelo.entidad.Planta;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ComandoPlantaTestDataBuilder {

    private Long id;
    private String nombre;
    private String descripcion;
    private LocalDate fechaIngreso;
    private int cantidad;
    private BigDecimal valor2;
    private CategoriaPlanta categoria;


    public ComandoPlantaTestDataBuilder crearPorDefecto(){
        this.id =1l;
        this.nombre ="manzanilla";
        this.descripcion="planta aromatica";
        this.fechaIngreso =LocalDate.of(2022,06,24);
        this.cantidad = 25;
        this.valor2 = new BigDecimal(8000);
        this.categoria = CategoriaPlanta.valueOf("AROMATICASYMEDICINALES");
        return this;
    }

    public Planta build(){return new Planta(id, nombre, descripcion, fechaIngreso, cantidad, valor2, categoria); }

}
