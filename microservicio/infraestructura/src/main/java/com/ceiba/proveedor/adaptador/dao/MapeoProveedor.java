package com.ceiba.proveedor.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.proveedor.modelo.dto.DtoProveedor;

import javax.swing.tree.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

//public class MapeoProveedor implements RowMapper<DtoProveedor>, MapperResult {
//
//
//    public DtoProveedor mapRow(ResultSet resultSet, int rowNum) throws SQLException {
//
//        var id = resultSet.getLong("id");
//        var nombre = resultSet.getString("nombre");
//        var direccion = resultSet.getString("direccion");
//        var telefono = resultSet.getString("telefono");
//        var paginaweb = resultSet.getString("paginaweb");
//
//        return new DtoProveedor(id, nombre, direccion, telefono, paginaweb);
//    }
//
//
//}