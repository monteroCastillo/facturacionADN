package com.ceiba.persona.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.persona.modelo.entidad.Persona;
import com.ceiba.persona.puerto.repositorio.RepositorioPersona;
import org.springframework.stereotype.Component;

import org.springframework.jdbc.core.RowMapper;
import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MapeoPersona implements RowMapper<Persona>, MapperResult {
    @Override
    public Persona mapRow(ResultSet resultSet, int rowNum)throws SQLException{

        var idPersona = resultSet.getLong("id_persona");
        var nombre = resultSet.getString("nombre");
        var direccion = resultSet.getString("direccion");
        var telefono = resultSet.getString("telefono");
        var email = resultSet.getString("email");
        var fechaRegistro = resultSet.getDate("fecha_registro").toLocalDate();

        return Persona.reconstruir(idPersona, nombre, direccion, telefono,email, fechaRegistro);
    }
}
