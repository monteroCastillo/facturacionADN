package com.ceiba.proveedor.consulta;

import com.ceiba.proveedor.modelo.dto.DtoProveedor;
import com.ceiba.proveedor.modelo.entidad.Proveedor;
import com.ceiba.proveedor.puerto.dao.DaoProveedor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarProveedores {

    private final DaoProveedor daoProveedor;
    public ManejadorListarProveedores(DaoProveedor daoProveedor) {
        this.daoProveedor = daoProveedor;
    }



    public List<Proveedor> ejecutar(){return this.daoProveedor.listar();}


}
