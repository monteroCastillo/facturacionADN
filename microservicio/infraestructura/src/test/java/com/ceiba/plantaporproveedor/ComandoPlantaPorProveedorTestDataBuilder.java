package com.ceiba.plantaporproveedor;

import com.ceiba.planta.modelo.entidad.CategoriaPlanta;
import com.ceiba.planta.modelo.entidad.Planta;
import com.ceiba.plantaporproveedor.comando.ComandoPlantaPorProveedor;
import com.ceiba.plantaporproveedor.comando.ComandoSolicitudPlantaPorProveedor;
import com.ceiba.plantaporproveedor.modelo.entidad.PlantaPorProveedor;
import com.ceiba.proveedor.modelo.entidad.Proveedor;

import java.math.BigDecimal;
import java.time.LocalDate;


public class ComandoPlantaPorProveedorTestDataBuilder {
    private Long id;
    private Long idProveedor;
    private int idPlanta;

    public ComandoPlantaPorProveedorTestDataBuilder crearPorDefecto(){
        this.id = 50L;
        this.idProveedor = 22l;
        this.idPlanta = 12;

//        this.idProveedor = new Proveedor(22l, "plantas y plantas", "Av vasquez Cobo", "5656565", "plantasyplantas.com.co");
//        this.idPlanta = new Planta(12, "Margarita", "flor amarilla", LocalDate.of(2022,06,8), 50, new BigDecimal(12000), CategoriaPlanta.valueOf("AROMATICASYMEDICINALES"));
        return this;
    }

    public ComandoSolicitudPlantaPorProveedor build(){
        return new ComandoSolicitudPlantaPorProveedor(this.idProveedor, this.idPlanta);
    }
}
