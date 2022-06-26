package com.ceiba.plantaporproveedor;

import com.ceiba.plantaporproveedor.comando.ComandoSolicitudPlantaPorProveedor;

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

    public ComandoSolicitudPlantaPorProveedor build(){
        return new ComandoSolicitudPlantaPorProveedor(this.idProveedor, this.idPlanta);
    }
}
