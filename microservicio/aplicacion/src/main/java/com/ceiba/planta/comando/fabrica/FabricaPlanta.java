package com.ceiba.planta.comando.fabrica;

import com.ceiba.planta.comando.ComandoPlanta;
import com.ceiba.planta.modelo.entidad.Planta;
import com.ceiba.planta.modelo.entidad.SolicitudCrearPlanta;
import com.ceiba.planta.puerto.repositorio.RepositorioPlanta;
import org.springframework.stereotype.Component;

@Component
public class FabricaPlanta {

    private final RepositorioPlanta repositorioPlanta;

    public FabricaPlanta(RepositorioPlanta repositorioPlanta) {
        this.repositorioPlanta = repositorioPlanta;
    }

    public SolicitudCrearPlanta guardarPlanta(ComandoPlanta comando){
        return new SolicitudCrearPlanta(comando.getId(), comando.getNombre(), comando.getDescripcion(), comando.getFechaIngreso(),comando.getCantidad(),comando.getValor(), comando.getCategoria());
    }

}
