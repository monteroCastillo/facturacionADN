package com.ceiba.plantaPorProveedor.adaptador.repositorio;

import com.ceiba.plantaPorProveedor.modelo.entidad.PlantaPorProveedor;
import com.ceiba.plantaPorProveedor.puerto.repositorio.RepositorioPlantaPorProveedor;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioPlantaporProveedorDB implements RepositorioPlantaPorProveedor {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    public RepositorioPlantaporProveedorDB(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @SqlStatement(namespace = "plantaPorProveedor", value = "crear")
    private static String sqlCrear;



    @SqlStatement(namespace="plantaPorProveedor", value="eliminar")
    private static String sqlEliminar;


    @Override
    public Long guardar(PlantaPorProveedor plantaPorProveedor) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", plantaPorProveedor.getId());
        parameterSource.addValue("id_proveedor", plantaPorProveedor.getProveedor().getId());
        parameterSource.addValue("id_planta", plantaPorProveedor.getPlanta().getIdPlanta());
        Long idPlantaGuardada = this.customNamedParameterJdbcTemplate.crear(parameterSource, sqlCrear);

        return idPlantaGuardada;
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }
}
