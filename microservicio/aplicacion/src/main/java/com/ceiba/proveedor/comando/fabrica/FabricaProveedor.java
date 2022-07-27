package com.ceiba.proveedor.comando.fabrica;

import com.ceiba.proveedor.comando.ComandoProveedor;
import com.ceiba.proveedor.modelo.entidad.SolicitudProveedor;
import org.springframework.stereotype.Component;

@Component
public class FabricaProveedor {

    public SolicitudProveedor guardarProveedor(ComandoProveedor comandoProveedor){
        return new SolicitudProveedor(comandoProveedor.getId(), comandoProveedor.getNombre(), comandoProveedor.getDireccion(), comandoProveedor.getTelefono(), comandoProveedor.getPaginaWeb());
    }
}
