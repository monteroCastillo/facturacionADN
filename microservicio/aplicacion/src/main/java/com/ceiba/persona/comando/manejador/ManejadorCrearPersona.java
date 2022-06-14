package com.ceiba.persona.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.factura.servicio.ServicioFacturar;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.persona.comando.ComandoPersona;
import com.ceiba.persona.comando.fabrica.FabricaPersona;
import com.ceiba.persona.modelo.entidad.Persona;
import com.ceiba.persona.servicio.ServicioCrearPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearPersona implements ManejadorComandoRespuesta <ComandoPersona, ComandoRespuesta<Long>> {

    private final ServicioCrearPersona servicioCrearPersona;
    private final FabricaPersona fabricaPersona;




    public ManejadorCrearPersona(FabricaPersona fabricaPersona, ServicioCrearPersona servicioCrearPersona  ) {
         this.fabricaPersona = fabricaPersona;
        this.servicioCrearPersona = servicioCrearPersona;
    }
    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoPersona comando) {
        Persona persona = this.fabricaPersona.crear(comando);
        return new ComandoRespuesta<>(this.servicioCrearPersona.ejecutar(persona));

    }


}
