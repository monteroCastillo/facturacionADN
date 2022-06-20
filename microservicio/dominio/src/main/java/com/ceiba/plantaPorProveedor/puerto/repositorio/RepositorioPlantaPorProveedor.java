package com.ceiba.plantaPorProveedor.puerto.repositorio;

import com.ceiba.plantaPorProveedor.modelo.entidad.PlantaPorProveedor;

public interface RepositorioPlantaPorProveedor {

    Long guardar(PlantaPorProveedor plantaPorProveedor);

    void eliminar(Long id);
}
