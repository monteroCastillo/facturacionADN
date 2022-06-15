package com.ceiba.proveedor.comando.fabrica;

import com.ceiba.proveedor.comando.ComandoProveedor;
import com.ceiba.proveedor.modelo.entidad.Proveedor;
import org.springframework.stereotype.Component;

@Component
public class FabricaProveedor {

    public Proveedor crear(ComandoProveedor comandoProveedor){
        return new Proveedor(
                comandoProveedor.getId(),
                comandoProveedor.getNombre(),
                comandoProveedor.getDireccion(),
                comandoProveedor.getTelefono(),
                comandoProveedor.getPaginaWeb()
        );
    }
}
