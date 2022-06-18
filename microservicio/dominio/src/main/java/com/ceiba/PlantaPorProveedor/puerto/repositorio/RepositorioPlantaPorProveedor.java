package com.ceiba.PlantaPorProveedor.puerto.repositorio;

import com.ceiba.PlantaPorProveedor.modelo.entidad.PlantaPorProveedor;

public interface RepositorioPlantaPorProveedor {

    Long guardar(PlantaPorProveedor plantaPorProveedor);

    void eliminar(Long id);
}
