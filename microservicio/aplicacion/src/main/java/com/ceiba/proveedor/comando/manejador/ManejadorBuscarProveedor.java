package com.ceiba.proveedor.comando.manejador;

import com.ceiba.proveedor.modelo.dto.DtoProveedor;
import com.ceiba.proveedor.puerto.dao.DaoProveedor;
import org.springframework.stereotype.Component;

@Component
public class ManejadorBuscarProveedor {

    private final DaoProveedor daoProveedor;

    public ManejadorBuscarProveedor(DaoProveedor daoProveedor) {
        this.daoProveedor = daoProveedor;
    }

    public DtoProveedor ejecutar(Long id){
        return this.daoProveedor.obtenerProveedorPorId(id);
    }
}
