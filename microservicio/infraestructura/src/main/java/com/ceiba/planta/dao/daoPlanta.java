package com.ceiba.planta.dao;

import com.ceiba.planta.entidad.Planta;
import com.ceiba.planta.puerto.repositorio.RepositorioPlanta;

import com.ceiba.planta.repositorio.RepositorioPlantaMysql;


import java.util.List;
import java.util.Optional;


public class daoPlanta implements RepositorioPlanta {


    private RepositorioPlantaMysql repoPlanta;
    @Override
    public void guardar(Planta planta) {
        repoPlanta.guardar(planta);
    }

    @Override
    public void eliminar(int idPlanta) {
        repoPlanta.buscarPlantaPorID(idPlanta);
    }

    @Override
    public List<Planta> buscarTodos() {
        return repoPlanta.buscarTodos();
    }

    @Override
    public Planta buscarPlantaPorID(int idPlanta) {
        return null;
    }
}
