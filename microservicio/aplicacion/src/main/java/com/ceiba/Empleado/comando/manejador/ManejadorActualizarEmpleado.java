package com.ceiba.Empleado.comando.manejador;

import com.ceiba.Empleado.comando.ComandoEmpleado;
import com.ceiba.Empleado.comando.fabrica.FabricaEmpleado;
import com.ceiba.Empleado.modelo.entidad.Empleado;
import com.ceiba.Empleado.servicio.ServicioActualizarEmpleado;
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
    public void ejecutar(ComandoEmpleado comandoProveedor) {
        Empleado empleado = this.fabricaEmpleado.crear(comandoProveedor);
        this.servicioActualizarEmpleado.ejecutar(empleado);
    }
}
