package com.ceiba.Empleado.puerto.dao;



import com.ceiba.Empleado.modelo.dto.DtoEmpleado;

import java.util.List;

public interface DaoEmpleado {
    List<DtoEmpleado> listar();
    DtoEmpleado obtenerEmpleadoPorId(Long id);
}
