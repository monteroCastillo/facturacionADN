package com.ceiba.PlantaPorProveedor.servicio;

import com.ceiba.PlantaPorProveedor.modelo.entidad.PlantaPorProveedor;
import com.ceiba.PlantaPorProveedor.puerto.repositorio.RepositorioPlantaPorProveedor;

public class ServicioCrearPlantaPorProveedor {

    private final RepositorioPlantaPorProveedor repositorioPlantaPorProveedor;


    public ServicioCrearPlantaPorProveedor(RepositorioPlantaPorProveedor repositorioPlantaPorProveedor) {
        this.repositorioPlantaPorProveedor = repositorioPlantaPorProveedor;
    }

    public Long ejecutar(PlantaPorProveedor plantaPorProveedor){
        return this.repositorioPlantaPorProveedor.guardar(plantaPorProveedor);
    }
}
