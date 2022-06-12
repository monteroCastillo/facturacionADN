package com.ceiba.planta.puerto.repositorio;


import com.ceiba.planta.entidad.Planta;

import java.util.List;
import java.util.Optional;

public interface RepositorioPlanta {

    void guardar(Planta planta);

    void eliminar(int idPlanta);

    List<Planta> buscarTodos();

    Planta buscarPlantaPorID(int idPlanta);
}
