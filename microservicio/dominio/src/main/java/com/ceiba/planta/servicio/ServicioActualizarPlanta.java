package com.ceiba.planta.servicio;


import com.ceiba.planta.modelo.entidad.Planta;
import com.ceiba.planta.modelo.entidad.SolicitudCrearPlanta;
import com.ceiba.planta.puerto.repositorio.RepositorioPlanta;

public class ServicioActualizarPlanta {

    private final RepositorioPlanta repositorioPlanta;

    public ServicioActualizarPlanta(RepositorioPlanta repositorioPlanta) {
        this.repositorioPlanta = repositorioPlanta;
    }

    public void ejecutar(SolicitudCrearPlanta solicitudCrearPlanta){

        var planta = Planta.crear(solicitudCrearPlanta);
        this.repositorioPlanta.actualizar(planta);
    }



}
