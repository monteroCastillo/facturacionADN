package com.ceiba.plantaporproveedor.adaptador.repositorio;


import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.plantaporproveedor.modelo.entidad.PlantaPorProveedor;
import com.ceiba.plantaporproveedor.puerto.repositorio.RepositorioPlantaPorProveedor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioPlantaporProveedorDB implements RepositorioPlantaPorProveedor {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    public RepositorioPlantaporProveedorDB(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @SqlStatement(namespace = "plantaporproveedor", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace="plantaporproveedor", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace="plantaporproveedor", value="obtenerporid")
    private static String sqlObtenerPorId;

    @SqlStatement(namespace="plantaporproveedor", value="existe")
    private static String sqlExiste;

    @Override
    public Long guardar(PlantaPorProveedor plantaPorProveedor) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", plantaPorProveedor.getId());
        parameterSource.addValue("id_proveedor", plantaPorProveedor.getIdProveedor());
        parameterSource.addValue("id_planta", plantaPorProveedor.getIdPlanta());
        return  this.customNamedParameterJdbcTemplate.crear(parameterSource, sqlCrear);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public boolean existe(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste, paramSource, Boolean.class);

    }


}
