package com.ceiba.plantaporproveedor.puerto.repositorio;

import com.ceiba.plantaporproveedor.modelo.entidad.PlantaPorProveedor;

public interface RepositorioPlantaPorProveedor {

    Long guardar(PlantaPorProveedor plantaPorProveedor);

    void eliminar(Long id);
    PlantaPorProveedor obtener(Long id);


}
