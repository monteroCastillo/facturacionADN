package com.ceiba.plantaporproveedor.servicio;

import com.ceiba.plantaporproveedor.modelo.entidad.PlantaPorProveedor;
import com.ceiba.plantaporproveedor.modelo.entidad.SolicitudCrearPlantaPorProveedor;
import com.ceiba.plantaporproveedor.puerto.repositorio.RepositorioPlantaPorProveedor;

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
