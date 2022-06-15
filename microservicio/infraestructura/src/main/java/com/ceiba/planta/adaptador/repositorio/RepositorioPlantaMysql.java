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

//    private static String sqlActualizarEstado;

    public RepositorioPlantaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;

    }
    public int guardar(Planta planta) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", planta.getIdPlanta());
        parameterSource.addValue("nombre", planta.getNombre());
        parameterSource.addValue("descripcion", planta.getDescripcion());
        parameterSource.addValue("fecha_ingreso",planta.getFechaIngreso());
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




    //    @Override
//    public Planta buscarPlantaPorID(int id_planta){
//        MapSqlParameterSource paramSource = new MapSqlParameterSource();
//        paramSource.addValue("id_planta", id_planta);
//        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() -> this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
//                .queryForObject(sqlObtenerPorId, paramSource, new MapeoPlanta()));
//    }


//    public int guardar(Planta planta) {
//        return Math.toIntExact(this.customNamedParameterJdbcTemplate.crear(planta, sqlCrear));
//    }



}
