package com.ceiba.empleado.puerto.dao;



import com.ceiba.empleado.modelo.dto.DtoEmpleado;

import java.util.List;

public interface DaoEmpleado {
    List<DtoEmpleado> listar();
    DtoEmpleado obtenerEmpleadoPorId(Long id);
}
