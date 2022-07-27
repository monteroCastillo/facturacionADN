package com.ceiba.planta.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.planta.comando.ComandoPlanta;
import com.ceiba.planta.comando.fabrica.FabricaPlanta;
import com.ceiba.planta.servicio.ServicioActualizarPlanta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarPlanta implements ManejadorComando<ComandoPlanta> {

    private final FabricaPlanta fabricaPlanta;

    private final ServicioActualizarPlanta servicioActualizarPlanta;


    public ManejadorActualizarPlanta(FabricaPlanta fabricaPlanta, ServicioActualizarPlanta servicioActualizarPlanta) {
        this.fabricaPlanta = fabricaPlanta;
        this.servicioActualizarPlanta = servicioActualizarPlanta;
    }

    @Override
    public void ejecutar(ComandoPlanta comandoPlanta) {
        this.servicioActualizarPlanta.ejecutar(fabricaPlanta.guardarPlanta(comandoPlanta));
    }
}
