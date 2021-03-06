package com.ceiba.plantaporproveedor.servicio;

import com.ceiba.plantaporproveedor.modelo.entidad.PlantaPorProveedor;
import com.ceiba.plantaporproveedor.puerto.repositorio.RepositorioPlantaPorProveedor;

public class ServicioCrearPlantaPorProveedor {

    private final RepositorioPlantaPorProveedor repositorioPlantaPorProveedor;


    public ServicioCrearPlantaPorProveedor(RepositorioPlantaPorProveedor repositorioPlantaPorProveedor) {
        this.repositorioPlantaPorProveedor = repositorioPlantaPorProveedor;
    }

    public Long ejecutar(PlantaPorProveedor plantaPorProveedor){

        return repositorioPlantaPorProveedor.guardar(plantaPorProveedor);
    }


}
