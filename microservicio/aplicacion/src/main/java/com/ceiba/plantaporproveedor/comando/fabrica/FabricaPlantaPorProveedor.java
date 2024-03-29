package com.ceiba.plantaporproveedor.comando.fabrica;

import com.ceiba.planta.puerto.dao.DaoPlanta;
import com.ceiba.plantaporproveedor.comando.ComandoPlantaPorProveedor;
import com.ceiba.plantaporproveedor.modelo.entidad.SolicitudCrearPlantaPorProveedor;
import com.ceiba.proveedor.puerto.dao.DaoProveedor;
import org.springframework.stereotype.Component;

@Component
public class FabricaPlantaPorProveedor {

    private final DaoPlanta daoPlanta;

    private final DaoProveedor daoProveedor;

    public FabricaPlantaPorProveedor(DaoPlanta daoPlanta, DaoProveedor daoProveedor) {
        this.daoPlanta = daoPlanta;
        this.daoProveedor = daoProveedor;
    }


    public SolicitudCrearPlantaPorProveedor guardarPlantaPorProveedor(ComandoPlantaPorProveedor comando){
        return  new SolicitudCrearPlantaPorProveedor(comando.getId(), daoProveedor.obtenerProveedorPorId(comando.getIdProveedor()), daoPlanta.obtenerPlantaPorId(comando.getIdPlanta()));

    }
}
