package com.ceiba.Empleado.adaptador.repositorio;


import com.ceiba.Empleado.modelo.dto.DtoEmpleado;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.EjecucionBaseDeDatos;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.Empleado.modelo.entidad.Empleado;
import com.ceiba.Empleado.puerto.repositorio.RepositorioEmpleado;
import com.ceiba.proveedor.modelo.entidad.Proveedor;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioEmpleadoMysql implements RepositorioEmpleado {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

   // private RepositorioPersona repoPersona;

    @SqlStatement(namespace = "empleado", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace = "empleado", value = "obtenerporid")
    private static String sqlObtenerPorId;

    @SqlStatement(namespace = "empleado", value = "actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="empleado", value="existe")
    private static String sqlExiste;


    public RepositorioEmpleadoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public DtoEmpleado buscarPersonaPorID(Long id_empleado){
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id_empleado", id_empleado);
        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() -> this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .queryForObject(sqlObtenerPorId, paramSource, new MapeoEmpleado()));
    }

    @Override
    public void actualizar(Empleado empleado) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", empleado.getIdEmpleado());
        paramSource.addValue("nombre", empleado.getNombre());
        paramSource.addValue("direccion", empleado.getDireccion());
        paramSource.addValue("telefono", empleado.getTelefono());
        paramSource.addValue("email", empleado.getEmail());
        paramSource.addValue("fecha_registro", empleado.getFechaRegistro());
        paramSource.addValue("perfil", empleado.getPerfil().name());
        System.out.println("El dato que le entra a actualizar " + paramSource);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlActualizar, paramSource);

    }


    @Override
    public boolean existe(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste, paramSource, Boolean.class);


    }

    @Override
    public Empleado obtener(Long idPersona) {
        return null;
    }

    @Override
    public Long guardar(Empleado empleado) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", empleado.getIdEmpleado());
        paramSource.addValue("nombre", empleado.getNombre());
        paramSource.addValue("direccion", empleado.getDireccion());
        paramSource.addValue("telefono", empleado.getTelefono());
        paramSource.addValue("email", empleado.getEmail());
        paramSource.addValue("fecha_registro", empleado.getFechaRegistro());
        paramSource.addValue("perfil", empleado.getPerfil().name());
        Long idEmpleadoGuardado = this.customNamedParameterJdbcTemplate.crear(paramSource, sqlCrear);

        return idEmpleadoGuardado;
    }
}
