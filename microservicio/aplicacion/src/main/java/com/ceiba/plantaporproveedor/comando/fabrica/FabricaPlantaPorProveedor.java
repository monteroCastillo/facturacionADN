package com.ceiba.plantaporproveedor.comando.fabrica;

import com.ceiba.plantaporproveedor.modelo.entidad.PlantaPorProveedor;
import com.ceiba.plantaporproveedor.comando.ComandoPlantaPorProveedor;
import org.springframework.stereotype.Component;

@Component
public class FabricaPlantaPorProveedor {

    public PlantaPorProveedor crear(ComandoPlantaPorProveedor comandoPlantaPorProveedor){

        return new PlantaPorProveedor(
                comandoPlantaPorProveedor.getId(),
                comandoPlantaPorProveedor.getIdProveedor(),
                comandoPlantaPorProveedor.getIdPlanta()
        );
    }
}
