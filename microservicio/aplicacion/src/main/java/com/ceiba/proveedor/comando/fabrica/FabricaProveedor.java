package com.ceiba.proveedor.comando.fabrica;

import com.ceiba.planta.puerto.dao.DaoPlanta;
import com.ceiba.plantaporproveedor.comando.ComandoPlantaPorProveedor;
import com.ceiba.plantaporproveedor.modelo.entidad.SolicitudCrearPlantaPorProveedor;
import com.ceiba.proveedor.comando.ComandoProveedor;
import com.ceiba.proveedor.modelo.entidad.SolicitudProveedor;
import com.ceiba.proveedor.puerto.dao.DaoProveedor;
import org.springframework.stereotype.Component;

@Component
public class FabricaProveedor {

    DaoProveedor daoProveedor;
    DaoPlanta daoPlanta;

    public FabricaProveedor(DaoProveedor daoProveedor, DaoPlanta daoPlanta) {
        this.daoProveedor = daoProveedor;
        this.daoPlanta = daoPlanta;
    }

    public SolicitudProveedor guardarProveedor(ComandoProveedor comando){
        return  new SolicitudProveedor(comando.getId(), comando.getNombre(), comando.getDireccion(), comando.getTelefono(), comando.getPaginaWeb());

    }

}
