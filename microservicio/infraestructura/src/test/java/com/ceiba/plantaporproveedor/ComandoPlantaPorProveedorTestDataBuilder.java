package com.ceiba.plantaporproveedor;

import com.ceiba.plantaporproveedor.comando.ComandoPlantaPorProveedor;
import com.ceiba.plantaporproveedor.modelo.entidad.PlantaPorProveedor;


public class ComandoPlantaPorProveedorTestDataBuilder {
    private Long id;
    private Long idProveedor;
    private int idPlanta;

    public ComandoPlantaPorProveedorTestDataBuilder crearPorDefecto(){
        this.id = 50L;
        this.idProveedor = 22l;
        this.idPlanta = 12;
        return this;
    }

    public ComandoPlantaPorProveedor build(){
        return  new ComandoPlantaPorProveedor(this.id, this.idProveedor, this.idPlanta);
    }
}
