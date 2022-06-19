package com.ceiba.PlantaPorProveedor.adaptador.dao;

import com.ceiba.PlantaPorProveedor.modelo.entidad.PlantaPorProveedor;
import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.planta.modelo.entidad.Planta;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

//public class MapeoPlantaPorProveedor implements RowMapper<PlantaPorProveedor>, MapperResult {
//
//
////    @Override
////    public PlantaPorProveedor mapRow(ResultSet resultSet, int rowNum) throws SQLException {
////        var id = resultSet.getLong("id");
////        var idProveedor = resultSet.getLong("id_proveedor");
////        var idPlanta = resultSet.getInt("id_planta");
////
////        return PlantaPorProveedor.reconstruir(id, idProveedor );
////    }
//}
