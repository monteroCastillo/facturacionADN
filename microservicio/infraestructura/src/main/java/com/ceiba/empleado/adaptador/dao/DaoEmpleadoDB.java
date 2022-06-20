package com.ceiba.empleado.adaptador.dao;

import com.ceiba.empleado.adaptador.repositorio.MapeoEmpleado;
import com.ceiba.empleado.modelo.dto.DtoEmpleado;
import com.ceiba.empleado.puerto.dao.DaoEmpleado;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoEmpleadoDB implements DaoEmpleado {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="empleado", value="listar")
    private static String sqlListar;

    @SqlStatement(namespace="empleado", value="obtenerporid")
    private static String sqlObtener;

    public DaoEmpleadoDB(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }


    @Override
    public List<DtoEmpleado> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoEmpleado());
    }

    @Override
    public DtoEmpleado obtenerEmpleadoPorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        List<DtoEmpleado> list=this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlObtener, paramSource, new MapeoEmpleado());
        if(list.size()==1){
            return list.get(0);
        }
        return null;
    }
}
