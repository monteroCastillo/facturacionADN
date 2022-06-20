package com.ceiba.plantaPorProveedor.servicio;

import com.ceiba.plantaPorProveedor.puerto.repositorio.RepositorioPlantaPorProveedor;

public class ServicioEliminarPlantaPorProveedor {
    private final RepositorioPlantaPorProveedor repositorioPlantaPorProveedor;


    public ServicioEliminarPlantaPorProveedor(RepositorioPlantaPorProveedor repositorioPlantaPorProveedor) {
        this.repositorioPlantaPorProveedor = repositorioPlantaPorProveedor;
    }

    public void  ejecutar(Long id){
       this.repositorioPlantaPorProveedor.eliminar(id);
    }
}
