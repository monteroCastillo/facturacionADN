package com.ceiba.empleado.servicio;


import com.ceiba.empleado.modelo.entidad.Empleado;
import com.ceiba.empleado.modelo.entidad.SolicitudCrearEmpleado;
import com.ceiba.empleado.puerto.repositorio.RepositorioEmpleado;

public class ServicioCrearEmpleado {

  private  final RepositorioEmpleado repositorioEmpleado;

    public ServicioCrearEmpleado(RepositorioEmpleado repositorioEmpleado) {

        this.repositorioEmpleado = repositorioEmpleado;
    }

    public Long ejecutar(SolicitudCrearEmpleado solicitudCrearEmpleado){

        var empleado = Empleado.crear(solicitudCrearEmpleado);
        return repositorioEmpleado.guardar(empleado);
    }

}
