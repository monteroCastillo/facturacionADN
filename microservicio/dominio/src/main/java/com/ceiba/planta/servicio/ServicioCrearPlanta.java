package com.ceiba.planta.servicio;

import com.ceiba.planta.modelo.entidad.Planta;
import com.ceiba.planta.puerto.repositorio.RepositorioPlanta;

public class ServicioCrearPlanta {

    private final RepositorioPlanta repositorioPlanta;

    public ServicioCrearPlanta(RepositorioPlanta repositorioPlanta) {
        this.repositorioPlanta = repositorioPlanta;
    }

    public Long ejecutar(Planta planta){
        return this.repositorioPlanta.guardar(planta);
    }
}
