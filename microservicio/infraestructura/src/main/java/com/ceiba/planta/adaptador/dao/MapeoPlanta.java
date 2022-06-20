package com.ceiba.planta.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.planta.modelo.entidad.CategoriaPlanta;
import com.ceiba.planta.modelo.entidad.Planta;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoPlanta implements RowMapper<Planta>, MapperResult {

    @Override
    public Planta mapRow(ResultSet resultSet, int rowNum)throws SQLException{

        var idPlanta = resultSet.getInt("id");
        var nombre = resultSet.getString("nombre");
        var descripcion = resultSet.getString("descripcion");
        var fechaIngreso = resultSet.getDate("fecha_ingreso").toLocalDate();
        var cantidad = resultSet.getInt("cantidad");
        var valor= resultSet.getBigDecimal("valor");
        var categoria = CategoriaPlanta.valueOf(resultSet.getString("categoria"));

        return Planta.reconstruir(idPlanta,nombre,descripcion,fechaIngreso, cantidad, valor, categoria);
    }
}