package com.ceiba.planta.adaptador.dao;


import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.planta.modelo.entidad.Planta;
import com.ceiba.planta.puerto.dao.DaoPlanta;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class DaoPlantaDB implements DaoPlanta{

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="planta", value="listar")
    private static String sqlListar;

    @SqlStatement(namespace="planta", value="obtenerporid")
    private static String sqlObtener;

    @SqlStatement(namespace="planta", value="listaConsulta")
    private static String sqlObtenerPlantaProveedor;


    public DaoPlantaDB(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }


    public List<Planta> plantaProveedor( Long proveedor) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", proveedor);
        System.out.println("DATO QUE LE ENTRA A LA CONSULTA: " + paramSource);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlObtenerPlantaProveedor, paramSource, new MapeoPlanta());
    }

    @Override
    public Planta obtenerPlantaPorId(int idPlanta) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", idPlanta);
        List<Planta> list=this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlObtener, paramSource, new MapeoPlanta());
        if(list.size()==1){
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<Planta> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoPlanta());
    }



    @Override
    public Planta obtener(int id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        List<Planta> list=this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlObtener, paramSource, new MapeoPlanta());
        if(list.size()==1){
            return list.get(0);
        }
        return null;
    }


    public Planta obtenerPlantaProveedor(int id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        List<Planta> list=this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlObtener, paramSource, new MapeoPlanta());
        if(list.size()==1){
            return list.get(0);
        }
        return null;
    }

}



