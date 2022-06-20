package com.ceiba.cliente.adaptador.dao;

import com.ceiba.cliente.adaptador.repositorio.MapeoCliente;
import com.ceiba.cliente.modelo.dto.DtoCliente;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.puerto.dao.DaoCliente;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class DaoClienteDB implements DaoCliente {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="cliente", value="listar")
    private static String sqlListar;

    @SqlStatement(namespace="cliente", value="obtenerporid")
    private static String sqlObtener;


    public DaoClienteDB(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoCliente> listar() {
        return null;
    }

    @Override
    public Cliente obtenerClientePorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        List<Cliente> list=this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlObtener, paramSource, new MapeoCliente());
        if(list.size()==1){
            return list.get(0);
        }
        return null;
    }

}
