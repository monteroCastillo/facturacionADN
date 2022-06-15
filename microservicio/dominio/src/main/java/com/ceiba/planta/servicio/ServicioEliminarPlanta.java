package com.ceiba.planta.servicio;

import com.ceiba.planta.puerto.repositorio.RepositorioPlanta;

public class ServicioEliminarPlanta {

    private final RepositorioPlanta repositorioPlanta;


    public ServicioEliminarPlanta(RepositorioPlanta repositorioPlanta) {
        this.repositorioPlanta = repositorioPlanta;
    }

    public void ejecutar(int id){this.repositorioPlanta.eliminar(id);}
}
