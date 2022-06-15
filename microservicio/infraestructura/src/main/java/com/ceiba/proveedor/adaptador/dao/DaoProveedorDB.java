package com.ceiba.proveedor.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.planta.adaptador.dao.MapeoPlanta;
import com.ceiba.planta.modelo.dto.DtoPlanta;
import com.ceiba.proveedor.modelo.dto.DtoProveedor;
import com.ceiba.proveedor.puerto.dao.DaoProveedor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
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
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoProveedor());

    }

    @Override
    public DtoProveedor obtenerProveedorPorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        List<DtoProveedor> list=this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlObtener, paramSource, new MapeoProveedor());
        if(list.size()==1){
            return list.get(0);
        }
        return null;
    }
}
