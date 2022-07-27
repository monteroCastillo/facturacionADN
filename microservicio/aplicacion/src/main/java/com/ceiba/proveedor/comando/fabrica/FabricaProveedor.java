package com.ceiba.proveedor.comando.fabrica;

import com.ceiba.proveedor.comando.ComandoProveedor;
import com.ceiba.proveedor.modelo.entidad.Proveedor;
import com.ceiba.proveedor.modelo.entidad.SolicitudProveedor;
import com.ceiba.proveedor.puerto.repositorio.RepositorioProveedor;
import org.springframework.stereotype.Component;

@Component
public class FabricaProveedor {

    private final RepositorioProveedor repositorioProveedor;

    public FabricaProveedor(RepositorioProveedor repositorioProveedor) {
        this.repositorioProveedor = repositorioProveedor;
    }

    public SolicitudProveedor guardarProveedor(ComandoProveedor comandoProveedor){
        return new SolicitudProveedor(comandoProveedor.getId(), comandoProveedor.getNombre(), comandoProveedor.getDireccion(), comandoProveedor.getTelefono(), comandoProveedor.getPaginaWeb());
    }
}
