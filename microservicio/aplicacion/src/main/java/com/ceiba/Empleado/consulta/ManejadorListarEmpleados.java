package com.ceiba.Empleado.consulta;

import com.ceiba.Empleado.modelo.dto.DtoEmpleado;
import com.ceiba.Empleado.puerto.dao.DaoEmpleado;
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
