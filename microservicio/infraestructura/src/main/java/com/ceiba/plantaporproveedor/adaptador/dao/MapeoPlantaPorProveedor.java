package com.ceiba.plantaporproveedor.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.planta.modelo.entidad.Planta;
import com.ceiba.plantaporproveedor.modelo.entidad.PlantaPorProveedor;
import com.ceiba.proveedor.modelo.entidad.Proveedor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoPlantaPorProveedor implements RowMapper<PlantaPorProveedor>, MapperResult {
    @Override
    public PlantaPorProveedor mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        var id = resultSet.getLong("id");
        var IdProveedor = resultSet.getObject("proveedor");
        var IdPlanta = resultSet.getObject("planta");

        return PlantaPorProveedor.reconstruir(id,new Proveedor(),new Planta());
    }
}
