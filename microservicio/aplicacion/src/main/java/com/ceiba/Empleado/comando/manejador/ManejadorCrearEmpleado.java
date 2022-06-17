package com.ceiba.Empleado.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.Empleado.comando.ComandoEmpleado;
import com.ceiba.Empleado.comando.fabrica.FabricaEmpleado;
import com.ceiba.Empleado.modelo.entidad.Empleado;
import com.ceiba.Empleado.servicio.ServicioCrearEmpleado;
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
