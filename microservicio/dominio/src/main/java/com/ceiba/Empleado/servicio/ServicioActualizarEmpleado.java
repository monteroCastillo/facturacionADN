package com.ceiba.Empleado.servicio;

import com.ceiba.Empleado.modelo.entidad.Empleado;
import com.ceiba.Empleado.puerto.repositorio.RepositorioEmpleado;
import com.ceiba.Empleado.utils.MensajesDeExcepcion;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;

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
