package com.ceiba.planta.puerto.dao;

import com.ceiba.planta.modelo.dto.DtoPlanta;

import java.util.List;

public interface DaoPlanta {
    List<DtoPlanta> listar();

    DtoPlanta obtenerPlantaPorId(int id);
}
