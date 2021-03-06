package com.ceiba.proveedor.comando.manejador;

import com.ceiba.proveedor.modelo.entidad.Proveedor;
import com.ceiba.proveedor.puerto.dao.DaoProveedor;
import org.springframework.stereotype.Component;

@Component
public class ManejadorBuscarProveedor {

    private final DaoProveedor daoProveedor;

    public ManejadorBuscarProveedor(DaoProveedor daoProveedor) {
        this.daoProveedor = daoProveedor;
    }

    public Proveedor ejecutar(Long id){
        return this.daoProveedor.obtenerProveedorPorId(id);
    }
}
