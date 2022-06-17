package com.ceiba.Empleado.puerto.repositorio;

import com.ceiba.Empleado.modelo.dto.DtoEmpleado;
import com.ceiba.Empleado.modelo.entidad.Empleado;
import com.ceiba.proveedor.modelo.entidad.Proveedor;

public interface RepositorioEmpleado {

    Empleado obtener(Long idEmpleado);
    Long guardar(Empleado empleado);
    DtoEmpleado buscarPersonaPorID(Long idEmpleado);

    void actualizar(Empleado empleado);
    boolean existe(Long id);
}
