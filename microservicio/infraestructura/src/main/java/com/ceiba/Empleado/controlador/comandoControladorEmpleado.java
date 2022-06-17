package com.ceiba.Empleado.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.Empleado.comando.ComandoEmpleado;
import com.ceiba.Empleado.comando.manejador.ManejadorActualizarEmpleado;
import com.ceiba.Empleado.comando.manejador.ManejadorCrearEmpleado;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apiEmpleado")
public class comandoControladorEmpleado {
    private final ManejadorCrearEmpleado manejadorCrearEmpleado;
    private final ManejadorActualizarEmpleado manejadorActualizarEmpleado;

    public comandoControladorEmpleado(ManejadorCrearEmpleado manejadorCrearEmpleado, ManejadorActualizarEmpleado manejadorActualizarEmpleado) {
        this.manejadorCrearEmpleado = manejadorCrearEmpleado;
        this.manejadorActualizarEmpleado = manejadorActualizarEmpleado;
    }
    @PostMapping({"/guardar"})
    public ComandoRespuesta<Long> guardar(@RequestBody ComandoEmpleado comandoEmpleado) {
       return manejadorCrearEmpleado.ejecutar(comandoEmpleado);

    }
    @PutMapping("/actualizar")
    public void actualizar(@RequestBody ComandoEmpleado comandoEmpleado) {
        manejadorActualizarEmpleado.ejecutar(comandoEmpleado);
    }

}
