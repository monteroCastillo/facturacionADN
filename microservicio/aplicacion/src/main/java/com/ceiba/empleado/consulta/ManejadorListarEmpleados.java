package com.ceiba.empleado.consulta;

import com.ceiba.empleado.modelo.dto.DtoEmpleado;
import com.ceiba.empleado.puerto.dao.DaoEmpleado;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ManejadorListarEmpleados {

    private final DaoEmpleado daoEmpleado;


    public ManejadorListarEmpleados(DaoEmpleado daoEmpleado) {
        this.daoEmpleado = daoEmpleado;
    }

    public List<DtoEmpleado> ejecutar(){return  this.daoEmpleado.listar();}
}
