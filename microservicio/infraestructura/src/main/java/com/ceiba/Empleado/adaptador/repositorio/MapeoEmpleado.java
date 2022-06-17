package com.ceiba.Empleado.adaptador.repositorio;

import com.ceiba.Empleado.modelo.dto.DtoEmpleado;
import com.ceiba.Empleado.modelo.entidad.Perfil;
import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.Empleado.modelo.entidad.Empleado;
import org.springframework.stereotype.Component;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MapeoEmpleado implements RowMapper<DtoEmpleado>, MapperResult {
    @Override
    public DtoEmpleado mapRow(ResultSet resultSet, int rowNum)throws SQLException{

        var idPersona = resultSet.getLong("id");
        var nombre = resultSet.getString("nombre");
        var direccion = resultSet.getString("direccion");
        var telefono = resultSet.getString("telefono");
        var email = resultSet.getString("email");
        var fechaRegistro = resultSet.getDate("fecha_registro").toLocalDate();
        var perfil= Perfil.valueOf(resultSet.getString("perfil"));

        return new DtoEmpleado(idPersona, nombre, direccion, telefono,email, fechaRegistro, perfil);
    }
}
