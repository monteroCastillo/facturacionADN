package com.ceiba.empleado.puerto.repositorio;

import com.ceiba.empleado.modelo.dto.DtoEmpleado;
import com.ceiba.empleado.modelo.entidad.Empleado;

public interface RepositorioEmpleado {

    Empleado obtener(Long idEmpleado);
    Long guardar(Empleado empleado);

    void actualizar(Empleado empleado);
    boolean existe(Long id);
}
