package com.ceiba.empleado.comando.manejador;

import com.ceiba.empleado.comando.ComandoEmpleado;
import com.ceiba.empleado.comando.fabrica.FabricaEmpleado;
import com.ceiba.empleado.modelo.entidad.Empleado;
import com.ceiba.empleado.servicio.ServicioActualizarEmpleado;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarEmpleado implements ManejadorComando<ComandoEmpleado> {


    private final FabricaEmpleado fabricaEmpleado;
    private final ServicioActualizarEmpleado servicioActualizarEmpleado;

    public ManejadorActualizarEmpleado(FabricaEmpleado fabricaEmpleado, ServicioActualizarEmpleado servicioActualizarEmpleado) {
        this.fabricaEmpleado = fabricaEmpleado;
        this.servicioActualizarEmpleado = servicioActualizarEmpleado;
    }

    @Override
    public void ejecutar(ComandoEmpleado comando) {

        this.servicioActualizarEmpleado.ejecutar(fabricaEmpleado.guardarEmpleado(comando));
    }
}
