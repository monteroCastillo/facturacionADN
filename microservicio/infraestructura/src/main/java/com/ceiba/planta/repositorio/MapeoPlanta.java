package com.ceiba.planta.repositorio;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.planta.entidad.Planta;


import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoPlanta implements RowMapper<Planta>, MapperResult {

    @Override
    public Planta mapRow(ResultSet resultSet, int rowNum)throws SQLException{

        var idPlanta = resultSet.getInt("id_persona");
        var nombre = resultSet.getString("nombre");
        var descripcion = resultSet.getString("descripcion");
        var fechaIngreso = resultSet.getDate("fecha_ingreso").toLocalDate();

        return Planta.reconstruir(idPlanta,nombre,descripcion,fechaIngreso);
    }
}
