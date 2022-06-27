package com.ceiba.plantaporproveedor.comando.fabrica;

import com.ceiba.planta.puerto.dao.DaoPlanta;
import com.ceiba.plantaporproveedor.comando.ComandoSolicitudPlantaPorProveedor;
import com.ceiba.plantaporproveedor.modelo.entidad.SolicitudCrearPlantaPorProveedor;
import com.ceiba.proveedor.puerto.dao.DaoProveedor;
import org.springframework.stereotype.Component;

@Component
public class FabricaSolicitudPlantaPorProveedor {

    private final DaoProveedor daoProveedor ;

    private final DaoPlanta daoPlanta;

    public FabricaSolicitudPlantaPorProveedor(DaoProveedor daoProveedor, DaoPlanta daoPlanta) {
        this.daoProveedor = daoProveedor;
        this.daoPlanta = daoPlanta;
    }
    public SolicitudCrearPlantaPorProveedor crear(ComandoSolicitudPlantaPorProveedor comandoSolicitudPlantaPorProveedor){

        return new SolicitudCrearPlantaPorProveedor(daoProveedor.obtenerProveedorPorId(comandoSolicitudPlantaPorProveedor.getIdProveedor()),
            daoPlanta.obtenerPlantaPorId(comandoSolicitudPlantaPorProveedor.getIdPlanta()));

    }

}
