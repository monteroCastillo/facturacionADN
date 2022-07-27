package com.ceiba.proveedor.comando.fabrica;

import com.ceiba.proveedor.comando.ComandoProveedor;
import com.ceiba.proveedor.modelo.entidad.SolicitudProveedor;
import org.springframework.stereotype.Component;

@Component
public class FabricaActualizarProveedor {

    public SolicitudProveedor actualizarProveedor(ComandoProveedor comandoProveedor){
        return new SolicitudProveedor(comandoProveedor.getId(), comandoProveedor.getNombre(), comandoProveedor.getDireccion(), comandoProveedor.getTelefono(), comandoProveedor.getPaginaWeb());
    }
}
