package com.ceiba.planta.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.planta.servicio.ServicioEliminarPlanta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarPlanta implements ManejadorComando<Integer> {
    private final ServicioEliminarPlanta servicioEliminarPlanta;

    public ManejadorEliminarPlanta(ServicioEliminarPlanta servicioEliminarPlanta) {
        this.servicioEliminarPlanta = servicioEliminarPlanta;
    }


    @Override
    public void ejecutar(Integer id) {
        this.servicioEliminarPlanta.ejecutar(id);
    }
}
