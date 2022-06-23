package com.ceiba.planta.comando.manejador;

import com.ceiba.planta.modelo.entidad.Planta;
import com.ceiba.planta.puerto.dao.DaoPlanta;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorPlantaProveedor {

    private final DaoPlanta daoPlanta;


    public ManejadorPlantaProveedor(DaoPlanta daoPlanta) {
        this.daoPlanta = daoPlanta;
    }

    public List<Planta> ejecutar(Long proveedor) {
        return this.daoPlanta.plantaProveedor(proveedor);
    }
}
