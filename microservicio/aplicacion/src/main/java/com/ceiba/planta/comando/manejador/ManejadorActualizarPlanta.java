package com.ceiba.planta.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.planta.comando.ComandoPlanta;
import com.ceiba.planta.comando.fabrica.FabricaPlanta;
import com.ceiba.planta.modelo.entidad.Planta;
import com.ceiba.planta.servicio.ServicioActualizarPlanta;
import com.ceiba.proveedor.modelo.entidad.Proveedor;
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
        Planta planta = this.fabricaPlanta.crear(comandoPlanta);
        this.servicioActualizarPlanta.ejecutar(planta);
    }
}
