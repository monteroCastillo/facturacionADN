package com.ceiba.cliente.adaptador.repositorio;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.modelo.entidad.TipoCliente;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoCliente implements RowMapper<Cliente>, MapperResult {

    @Override
    public Cliente mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        var id = resultSet.getLong("id");
        var nombre = resultSet.getString("nombre");
        var direccion = resultSet.getString("direccion");
        var telefono = resultSet.getString("telefono");
        var email = resultSet.getString("email");
        var tipoCliente = TipoCliente.valueOf(resultSet.getString("tipo_cliente"));
        return Cliente.reconstruir(id, nombre,direccion, telefono, email, tipoCliente);
    }

}
