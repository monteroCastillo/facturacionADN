package com.ceiba.planta.puerto.dao;

import com.ceiba.planta.modelo.entidad.Planta;

import java.util.List;

public interface DaoPlanta {
    List<Planta> listar();

    Planta obtenerPlantaPorId(int id);

    Planta obtener(int id);

    List<Planta> plantaProveedor(Long proveedor);


}
