package com.ceiba.empleado.servicio;

import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.empleado.modelo.entidad.Empleado;
import com.ceiba.empleado.modelo.entidad.SolicitudCrearEmpleado;
import com.ceiba.empleado.puerto.repositorio.RepositorioEmpleado;
import com.ceiba.empleado.utils.MensajesDeExcepcion;

public class ServicioActualizarEmpleado {
    private final RepositorioEmpleado repositorioEmpleado;


    public ServicioActualizarEmpleado(RepositorioEmpleado repositorioEmpleado) {
        this.repositorioEmpleado = repositorioEmpleado;
    }

    public void ejecutar(SolicitudCrearEmpleado solicitudCrearEmpleado){
        validarExistenciaPrevia(solicitudCrearEmpleado);
        var empleado = Empleado.crear(solicitudCrearEmpleado);
        this.repositorioEmpleado.actualizar(empleado);
    }

    private void validarExistenciaPrevia(SolicitudCrearEmpleado solicitudCrearEmpleado){
        boolean existe = this.repositorioEmpleado.existe(solicitudCrearEmpleado.getIdEmpleado());
        if(!existe) {
            throw new ExcepcionSinDatos(MensajesDeExcepcion.NO_EXISTE_UNA_PERSONA_REGISTRADO_CON_ESTE_ID.getMensaje());
        }
    }

}
