package com.ceiba.planta.puerto.dao;

import com.ceiba.planta.modelo.entidad.Planta;

import java.util.List;

public interface DaoPlanta {
    List<Planta> listar();

    Planta obtenerPlantaPorId(Long id);

    Planta obtener(Long id);

    List<Planta> plantaProveedor(Long proveedor);


}
