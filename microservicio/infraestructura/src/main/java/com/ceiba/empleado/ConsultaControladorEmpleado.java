package com.ceiba.empleado;

import com.ceiba.empleado.consulta.ManejadorListarEmpleados;
import com.ceiba.empleado.modelo.dto.DtoEmpleado;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/empleados")
public class ConsultaControladorEmpleado {

    private final ManejadorListarEmpleados manejadorListarEmpleados;

    public ConsultaControladorEmpleado(ManejadorListarEmpleados manejadorListarEmpleados) {
        this.manejadorListarEmpleados = manejadorListarEmpleados;
    }

    @GetMapping("/index")
    public List<DtoEmpleado> listar(){
        return this.manejadorListarEmpleados.ejecutar();
    }
}
