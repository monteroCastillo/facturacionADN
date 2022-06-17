package com.ceiba.planta.comando.fabrica;

import com.ceiba.planta.comando.ComandoPlanta;
import com.ceiba.planta.modelo.entidad.Planta;
import org.springframework.stereotype.Component;

@Component
public class FabricaPlanta {

    public Planta crear(ComandoPlanta comandoPlanta){
      return new Planta(
             comandoPlanta.getIdPlanta(),
             comandoPlanta.getNombre(),
             comandoPlanta.getDescripcion(),
              comandoPlanta.getFechaIngreso(),
              comandoPlanta.getCantidad(),
              comandoPlanta.getCategoria()
      );
    }
}
