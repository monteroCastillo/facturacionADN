package com.ceiba.planta.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.planta.comando.ComandoPlanta;
import com.ceiba.planta.comando.fabrica.FabricaPlanta;
import com.ceiba.planta.servicio.ServicioCrearPlanta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearPlanta implements ManejadorComandoRespuesta<ComandoPlanta, ComandoRespuesta<Long>> {
    private final ServicioCrearPlanta servicioCrearPlanta;

    private final FabricaPlanta fabricaPlanta;

    public ManejadorCrearPlanta(ServicioCrearPlanta servicioCrearPlanta, FabricaPlanta fabricaPlanta) {
        this.servicioCrearPlanta = servicioCrearPlanta;
        this.fabricaPlanta = fabricaPlanta;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoPlanta comando) {
        return  new ComandoRespuesta<>(this.servicioCrearPlanta.ejecutar(fabricaPlanta.guardarPlanta(comando)));
    }


}
