package com.ceiba.plantaporproveedor.servicio;

import com.ceiba.plantaporproveedor.puerto.repositorio.RepositorioPlantaPorProveedor;

public class ServicioEliminarPlantaPorProveedor {
    private final RepositorioPlantaPorProveedor repositorioPlantaPorProveedor;


    public ServicioEliminarPlantaPorProveedor(RepositorioPlantaPorProveedor repositorioPlantaPorProveedor) {
        this.repositorioPlantaPorProveedor = repositorioPlantaPorProveedor;
    }

    public void  ejecutar(Long id){
       this.repositorioPlantaPorProveedor.eliminar(id);
    }
}
