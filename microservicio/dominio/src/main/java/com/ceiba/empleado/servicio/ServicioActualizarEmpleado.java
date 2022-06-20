package com.ceiba.empleado.servicio;

import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.empleado.modelo.entidad.Empleado;
import com.ceiba.empleado.puerto.repositorio.RepositorioEmpleado;
import com.ceiba.empleado.utils.MensajesDeExcepcion;

public class ServicioActualizarEmpleado {
    private final RepositorioEmpleado repositorioEmpleado;


    public ServicioActualizarEmpleado(RepositorioEmpleado repositorioEmpleado) {
        this.repositorioEmpleado = repositorioEmpleado;
    }

    public void ejecutar(Empleado empleado){
        validarExistenciaPrevia(empleado);
        this.repositorioEmpleado.actualizar(empleado);
    }

    private void validarExistenciaPrevia(Empleado empleado){
        boolean existe = this.repositorioEmpleado.existe(empleado.getIdEmpleado());
        if(!existe) {
            throw new ExcepcionSinDatos(MensajesDeExcepcion.NO_EXISTE_UNA_PERSONA_REGISTRADO_CON_ESTE_ID.getMensaje());
        }
    }

}
