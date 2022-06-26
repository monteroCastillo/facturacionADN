package com.ceiba.empleado;

import com.ceiba.ComandoRespuesta;
import com.ceiba.empleado.comando.ComandoEmpleado;
import com.ceiba.empleado.comando.manejador.ManejadorActualizarEmpleado;
import com.ceiba.empleado.comando.manejador.ManejadorCrearEmpleado;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apiEmpleado")
public class ComandoControladorEmpleado {
    private final ManejadorCrearEmpleado manejadorCrearEmpleado;
    private final ManejadorActualizarEmpleado manejadorActualizarEmpleado;

    public ComandoControladorEmpleado(ManejadorCrearEmpleado manejadorCrearEmpleado, ManejadorActualizarEmpleado manejadorActualizarEmpleado) {
        this.manejadorCrearEmpleado = manejadorCrearEmpleado;
        this.manejadorActualizarEmpleado = manejadorActualizarEmpleado;
    }
    @PostMapping({"/guardar"})
    public ComandoRespuesta<Long> guardar(@RequestBody ComandoEmpleado comandoEmpleado) {
       return manejadorCrearEmpleado.ejecutar(comandoEmpleado);

    }


}
