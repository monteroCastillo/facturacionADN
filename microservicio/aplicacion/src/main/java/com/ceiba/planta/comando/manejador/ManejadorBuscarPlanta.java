package com.ceiba.planta.comando.manejador;

import com.ceiba.planta.modelo.dto.DtoPlanta;
import com.ceiba.planta.modelo.entidad.Planta;
import com.ceiba.planta.puerto.dao.DaoPlanta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorBuscarPlanta {

    private final DaoPlanta daoPlanta;

    public ManejadorBuscarPlanta(DaoPlanta daoPlanta) {
        this.daoPlanta = daoPlanta;
    }

    public Planta ejecutar(int id){
        return this.daoPlanta.obtenerPlantaPorId(id);
    }
}
