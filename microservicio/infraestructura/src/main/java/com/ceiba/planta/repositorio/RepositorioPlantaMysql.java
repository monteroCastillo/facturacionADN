package com.ceiba.planta.repositorio;


import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.planta.entidad.Planta;
import com.ceiba.planta.puerto.repositorio.RepositorioPlanta;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioPlantaMysql implements RepositorioPlanta  {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;



//    @SqlStatement(namespace = "planta", value = "crear")
//    private static String sqlCrear;

//    @SqlStatement(namespace = "planta", value = "obtenerporid")
//    private static String sqlObtenerPorId;
//
//    @SqlStatement(namespace = "factura", value = "actualizarestado")
//    private static String sqlActualizarEstado;

    public RepositorioPlantaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;

    }



    @Override
    public void guardar(Planta planta) {

    }

    @Override
    public void eliminar(int idPlanta) {

    }

    @Override
    public List<Planta> buscarTodos() {
        return null;
    }

    @Override
    public Planta buscarPlantaPorID(int idPlanta) {
        return null;
    }
}
