package com.ceiba.empleado.servicio;

import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.empleado.modelo.entidad.Empleado;
import com.ceiba.empleado.modelo.entidad.SolicitudCrearEmpleado;
import com.ceiba.empleado.puerto.repositorio.RepositorioEmpleado;
import com.ceiba.empleado.utils.MensajesDeExcepcion;

public class ServicioCrearEmpleado {

  private  final RepositorioEmpleado repositorioEmpleado;

    public ServicioCrearEmpleado(RepositorioEmpleado repositorioEmpleado) {

        this.repositorioEmpleado = repositorioEmpleado;
    }

    public Long ejecutar(SolicitudCrearEmpleado solicitudCrearEmpleado){
        validarExistenciaPrevia(solicitudCrearEmpleado);
        var empleado = Empleado.crear(solicitudCrearEmpleado);
        return repositorioEmpleado.guardar(empleado);
    }
    private void validarExistenciaPrevia(SolicitudCrearEmpleado solicitudCrearEmpleado)  {
        boolean existe = this.repositorioEmpleado.existe(solicitudCrearEmpleado.getIdEmpleado());
        if(existe){
            throw new ExcepcionValorInvalido(MensajesDeExcepcion.YA_EXISTE_UNA_PERSONA_REGISTRADA_CON_ESTE_ID.getMensaje());
        }
    }
}
