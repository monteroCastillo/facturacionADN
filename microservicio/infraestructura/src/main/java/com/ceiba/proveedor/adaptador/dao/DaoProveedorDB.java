package com.ceiba.proveedor.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.proveedor.modelo.dto.DtoProveedor;
import com.ceiba.proveedor.puerto.dao.DaoProveedor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoProveedorDB implements DaoProveedor {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="proveedor", value="listar")
    private static String sqlListar;

    @SqlStatement(namespace="proveedor", value="obtenerporid")
    private static String sqlObtener;

    public DaoProveedorDB(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }


    @Override
    public List<DtoProveedor> listar() {
       // return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoProveedor());
        return null;
    }

    @Override
    public DtoProveedor obtenerProveedorPorId(Long id) {
        return null;
    }
}
