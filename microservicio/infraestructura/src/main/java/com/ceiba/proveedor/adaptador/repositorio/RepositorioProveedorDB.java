package com.ceiba.proveedor.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.proveedor.modelo.entidad.Proveedor;
import com.ceiba.proveedor.puerto.repositorio.RepositorioProveedor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class RepositorioProveedorDB implements RepositorioProveedor {


    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    public RepositorioProveedorDB(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @SqlStatement(namespace = "proveedor", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "proveedor", value = "obtenerporid")
    private static String sqlObtenerPorId;//

    @SqlStatement(namespace="proveedor", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace="proveedor", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="proveedor", value="existe")
    private static String sqlExiste;

    @Override
    public Long guardar(Proveedor proveedor) {
        return (this.customNamedParameterJdbcTemplate.crear(proveedor, sqlCrear));
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }


    @Override
    public void actualizar(Proveedor proveedor) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", proveedor.getId());
        paramSource.addValue("nombre", proveedor.getNombre());
        paramSource.addValue("direccion", proveedor.getDireccion());
        paramSource.addValue("telefono", proveedor.getTelefono());
        paramSource.addValue("paginaWeb", proveedor.getPaginaWeb());
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlActualizar, paramSource);

    }

    @Override
    public boolean existe(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste, paramSource, Boolean.class);
    }


}
