package com.ceiba.proveedor.consulta;

import com.ceiba.proveedor.modelo.dto.DtoProveedor;
import com.ceiba.proveedor.puerto.dao.DaoProveedor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarProveedores {

    public ManejadorListarProveedores(DaoProveedor daoProveedor) {
        this.daoProveedor = daoProveedor;
    }

    private final DaoProveedor daoProveedor;

    public List<DtoProveedor> ejecutar(){return this.daoProveedor.listar();}


}
