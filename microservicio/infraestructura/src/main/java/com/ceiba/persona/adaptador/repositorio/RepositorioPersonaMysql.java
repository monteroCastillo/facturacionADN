package com.ceiba.persona.adaptador.repositorio;


import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.EjecucionBaseDeDatos;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.persona.modelo.entidad.Persona;
import com.ceiba.persona.puerto.repositorio.RepositorioPersona;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RepositorioPersonaMysql implements RepositorioPersona {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    private RepositorioPersona repoPersona;

    @SqlStatement(namespace = "persona", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "persona", value = "obtenerporid")
    private static String sqlObtenerPorId;

   // @SqlStatement(namespace = "persona", value = "actualizarestado")
   // private static String sqlActualizarEstado;

  //  @SqlStatement(namespace = "persona", value = "buscartodos")
  //  private static String sqlBuscarTodos;

    public RepositorioPersonaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;

    }

    @Override
    public Persona buscarPersonaPorID(Long id_persona){
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id_persona", id_persona);
        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() -> this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .queryForObject(sqlObtenerPorId, paramSource, new MapeoPersona()));
    }

    @Override
    public Persona obtener(Long idPersona) {
        return null;
    }

    @Override
    public Long guardar(Persona persona) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id_persona", persona.getIdPersona());
        paramSource.addValue("nombre", persona.getNombre());
        paramSource.addValue("direccion", persona.getDireccion());
        paramSource.addValue("telefono", persona.getTelefono());
        paramSource.addValue("email", persona.getEmail());
        paramSource.addValue("fecha_registro", persona.getDireccion());
        Long idPersonaGuardada = this.customNamedParameterJdbcTemplate.crear(paramSource, sqlCrear);
        //repoPersona.guardar(persona);
        return idPersonaGuardada;
    }

//    @Override
//    public void guardar(Persona persona) {
//
//    }
//
//    @Override
//    public void eliminar(Long idPersona) {
//
//    }
//
//    @Override
//    public List<Persona> buscarTodos() {
//        return null;
//    }


}
