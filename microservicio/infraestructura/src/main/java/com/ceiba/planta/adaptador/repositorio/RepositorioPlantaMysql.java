package com.ceiba.planta.adaptador.repositorio;


import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.planta.modelo.entidad.Planta;
import com.ceiba.planta.puerto.repositorio.RepositorioPlanta;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioPlantaMysql implements RepositorioPlanta  {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "planta", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "planta", value = "obtenerporid")
    private static String sqlObtenerPorId;//

    @SqlStatement(namespace="planta", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace="planta", value="existe")
    private static String sqlExiste;

    @SqlStatement(namespace="planta", value="actualizar")
    private static String sqlActualizar;


    public RepositorioPlantaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;

    }
    public int guardar(Planta planta) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", planta.getIdPlanta());
        parameterSource.addValue("nombre", planta.getNombre());
        parameterSource.addValue("descripcion", planta.getDescripcion());
        parameterSource.addValue("fecha_ingreso",planta.getFechaIngreso());
        parameterSource.addValue("cantidad",planta.getCantidad());
        parameterSource.addValue("valor",planta.getValor());
        parameterSource.addValue("categoria",planta.getCategoria().name());
        Long idPlantaGuardada = this.customNamedParameterJdbcTemplate.crear(parameterSource, sqlCrear);
        return Math.toIntExact(idPlantaGuardada);
    }

    @Override
    public void eliminar(int id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public List<Planta> buscarTodos() {
        return null;
    }


    @Override
    public void actualizar(Planta planta) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", planta.getIdPlanta());
        paramSource.addValue("nombre", planta.getNombre());
        paramSource.addValue("descripcion", planta.getDescripcion());
        paramSource.addValue("fecha_ingreso", planta.getFechaIngreso());
        paramSource.addValue("cantidad", planta.getCantidad());
        paramSource.addValue("valor",planta.getValor());
        paramSource.addValue("categoria", planta.getCategoria().name());
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlActualizar, paramSource);

    }
    @Override
    public boolean existe(int id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste, paramSource, Boolean.class);
    }
}
