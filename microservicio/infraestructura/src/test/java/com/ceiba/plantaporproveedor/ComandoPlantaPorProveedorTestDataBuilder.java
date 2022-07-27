package com.ceiba.plantaporproveedor;

import com.ceiba.plantaporproveedor.comando.ComandoPlantaPorProveedor;



public class ComandoPlantaPorProveedorTestDataBuilder {
    private Long id;
    private Long idProveedor;
    private Long idPlanta;

    public ComandoPlantaPorProveedorTestDataBuilder crearPorDefecto(){
        this.id = 50L;
        this.idPlanta = 1l;
        this.idProveedor = 1l;
        return this;
    }

    public ComandoPlantaPorProveedor build(){
        return new ComandoPlantaPorProveedor(this.id, this.idProveedor, this.idPlanta);
    }
}
