package com.ceiba.proveedor.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.proveedor.modelo.dto.DtoProveedor;

import com.ceiba.proveedor.modelo.entidad.Proveedor;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoProveedor implements RowMapper<Proveedor>, MapperResult {

    @Override
    public Proveedor mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        var id = resultSet.getLong("id");
        var nombre = resultSet.getString("nombre");
        var direccion = resultSet.getString("direccion");
        var telefono = resultSet.getString("telefono");
        var paginaweb = resultSet.getString("paginaweb");

        return  Proveedor.reconstruir(id, nombre, direccion, telefono, paginaweb);
    }


}