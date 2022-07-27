package com.ceiba.planta.servicio;

import com.ceiba.planta.modelo.entidad.Planta;
import com.ceiba.planta.modelo.entidad.SolicitudCrearPlanta;
import com.ceiba.planta.puerto.repositorio.RepositorioPlanta;

public class ServicioCrearPlanta {

    private final RepositorioPlanta repositorioPlanta;

    public ServicioCrearPlanta(RepositorioPlanta repositorioPlanta) {
        this.repositorioPlanta = repositorioPlanta;
    }

    public Long ejecutar(SolicitudCrearPlanta solicitudCrearPlanta){
        var planta = Planta.crear(solicitudCrearPlanta);
        return this.repositorioPlanta.guardar(planta);
    }
}
