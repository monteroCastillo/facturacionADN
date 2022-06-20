package com.ceiba.planta.consulta;

import com.ceiba.planta.modelo.entidad.Planta;
import com.ceiba.planta.puerto.dao.DaoPlanta;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarPlantas {

    private final DaoPlanta daoPlanta;

    public ManejadorListarPlantas(DaoPlanta daoPlanta) {
        this.daoPlanta = daoPlanta;
    }


    public List<Planta> ejecutar(){
        return this.daoPlanta.listar();
    }


}
