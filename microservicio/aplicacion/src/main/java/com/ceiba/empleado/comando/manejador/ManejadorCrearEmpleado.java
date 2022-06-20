package com.ceiba.empleado.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.empleado.comando.ComandoEmpleado;
import com.ceiba.empleado.comando.fabrica.FabricaEmpleado;
import com.ceiba.empleado.modelo.entidad.Empleado;
import com.ceiba.empleado.servicio.ServicioCrearEmpleado;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearEmpleado implements ManejadorComandoRespuesta <ComandoEmpleado, ComandoRespuesta<Long>> {

    private final ServicioCrearEmpleado servicioCrearEmpleado;
    private final FabricaEmpleado fabricaEmpleado;




    public ManejadorCrearEmpleado(FabricaEmpleado fabricaEmpleado, ServicioCrearEmpleado servicioCrearEmpleado) {
         this.fabricaEmpleado = fabricaEmpleado;
        this.servicioCrearEmpleado = servicioCrearEmpleado;
    }
    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoEmpleado comando) {
        Empleado empleado = this.fabricaEmpleado.crear(comando);
        return new ComandoRespuesta<>(this.servicioCrearEmpleado.ejecutar(empleado));

    }


}
