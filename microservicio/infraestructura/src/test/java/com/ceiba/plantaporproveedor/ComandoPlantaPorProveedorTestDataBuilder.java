package com.ceiba.plantaporproveedor;

import com.ceiba.planta.modelo.entidad.Planta;
import com.ceiba.plantaporproveedor.comando.ComandoPlantaPorProveedor;
import com.ceiba.plantaporproveedor.modelo.entidad.PlantaPorProveedor;
import com.ceiba.proveedor.modelo.entidad.Proveedor;


public class ComandoPlantaPorProveedorTestDataBuilder {
    private Long id;
    private Proveedor proveedor;
    private Planta planta;

    public ComandoPlantaPorProveedorTestDataBuilder crearPorDefecto(){
        this.id = 50L;
        this.planta = planta;
        this.proveedor = proveedor;
        return this;
    }

    public ComandoPlantaPorProveedor reconstruir(){
        return  new ComandoPlantaPorProveedor(this.id,proveedor, planta);
    }
}
