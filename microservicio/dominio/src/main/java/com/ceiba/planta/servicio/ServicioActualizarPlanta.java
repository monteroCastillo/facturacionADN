package com.ceiba.planta.servicio;

import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.empleado.utils.MensajesDeExcepcion;
import com.ceiba.planta.modelo.entidad.Planta;
import com.ceiba.planta.modelo.entidad.SolicitudCrearPlanta;
import com.ceiba.planta.puerto.repositorio.RepositorioPlanta;

public class ServicioActualizarPlanta {

    private final RepositorioPlanta repositorioPlanta;

    public ServicioActualizarPlanta(RepositorioPlanta repositorioPlanta) {
        this.repositorioPlanta = repositorioPlanta;
    }

    public void ejecutar(SolicitudCrearPlanta solicitudCrearPlanta){
        validarExistenciaPrevia(solicitudCrearPlanta);
        var planta = Planta.crear(solicitudCrearPlanta);
        this.repositorioPlanta.actualizar(planta);
    }

    private void validarExistenciaPrevia(SolicitudCrearPlanta solicitudCrearPlanta){
        boolean existe = this.repositorioPlanta.existe(solicitudCrearPlanta.getId());
        if(!existe) {
            throw new ExcepcionSinDatos(MensajesDeExcepcion.NO_EXISTE_UNA_PERSONA_REGISTRADO_CON_ESTE_ID.getMensaje());
        }
    }

}
