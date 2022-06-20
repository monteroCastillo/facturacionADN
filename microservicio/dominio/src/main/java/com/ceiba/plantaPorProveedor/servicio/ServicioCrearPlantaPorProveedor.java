package com.ceiba.plantaPorProveedor.servicio;

import com.ceiba.plantaPorProveedor.modelo.entidad.PlantaPorProveedor;
import com.ceiba.plantaPorProveedor.modelo.entidad.SolicitudCrearPlantaPorProveedor;
import com.ceiba.plantaPorProveedor.puerto.repositorio.RepositorioPlantaPorProveedor;

public class ServicioCrearPlantaPorProveedor {

    private final RepositorioPlantaPorProveedor repositorioPlantaPorProveedor;


    public ServicioCrearPlantaPorProveedor(RepositorioPlantaPorProveedor repositorioPlantaPorProveedor) {
        this.repositorioPlantaPorProveedor = repositorioPlantaPorProveedor;
    }

//    public Long ejecutar(PlantaPorProveedor plantaPorProveedor){
//        return this.repositorioPlantaPorProveedor.guardar(plantaPorProveedor);
//    }
    public Long ejecutar(SolicitudCrearPlantaPorProveedor solicitudCrearPlantaPorProveedor){
        var plantaPorProveedor = PlantaPorProveedor.crear(solicitudCrearPlantaPorProveedor);

        return repositorioPlantaPorProveedor.guardar(plantaPorProveedor);
    }
}
