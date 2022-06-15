package com.ceiba.planta.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.planta.modelo.dto.DtoPlanta;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoPlanta implements RowMapper<DtoPlanta>, MapperResult {

    @Override
    public DtoPlanta mapRow(ResultSet resultSet, int rowNum)throws SQLException{

        var idPlanta = resultSet.getInt("id");
        var nombre = resultSet.getString("nombre");
        var descripcion = resultSet.getString("descripcion");
        var fechaIngreso = resultSet.getDate("fecha_ingreso").toLocalDate();

        return new DtoPlanta(idPlanta,nombre,descripcion,fechaIngreso);
    }
}
