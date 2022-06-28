package com.ceiba.empleado;

import com.ceiba.ComandoRespuesta;
import com.ceiba.empleado.comando.ComandoEmpleado;
import com.ceiba.empleado.comando.manejador.ManejadorCrearEmpleado;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apiEmpleado")
public class ComandoControladorEmpleado {
    private final ManejadorCrearEmpleado manejadorCrearEmpleado;


    public ComandoControladorEmpleado(ManejadorCrearEmpleado manejadorCrearEmpleado) {
        this.manejadorCrearEmpleado = manejadorCrearEmpleado;

    }
    @PostMapping({"/guardar"})
    public ComandoRespuesta<Long> guardar(@RequestBody ComandoEmpleado comandoEmpleado) {
       return manejadorCrearEmpleado.ejecutar(comandoEmpleado);
    }

}
