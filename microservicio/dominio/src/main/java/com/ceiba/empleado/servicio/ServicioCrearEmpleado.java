package com.ceiba.empleado.servicio;

import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.empleado.modelo.entidad.Empleado;
import com.ceiba.empleado.puerto.repositorio.RepositorioEmpleado;
import com.ceiba.empleado.utils.MensajesDeExcepcion;

public class ServicioCrearEmpleado {

  private  final RepositorioEmpleado repositorioEmpleado;


    public ServicioCrearEmpleado(RepositorioEmpleado repositorioEmpleado) {

        this.repositorioEmpleado = repositorioEmpleado;
    }

    public Long ejecutar(Empleado empleado){
        validarExistenciaPrevia(empleado);
        return this.repositorioEmpleado.guardar(empleado);
    }
    private void validarExistenciaPrevia(Empleado empleado)  {
        boolean existe = this.repositorioEmpleado.existe(empleado.getIdEmpleado());
        if(existe){
            throw new ExcepcionValorInvalido(MensajesDeExcepcion.YA_EXISTE_UNA_PERSONA_REGISTRADA_CON_ESTE_ID.getMensaje());
        }

    }
}
