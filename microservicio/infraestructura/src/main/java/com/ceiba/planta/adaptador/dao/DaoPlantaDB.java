package com.ceiba.planta.adaptador.dao;


import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.planta.modelo.dto.DtoPlanta;
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


    public DaoPlantaDB(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }
    @Override
    public List<DtoPlanta> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoPlanta());
    }

    @Override
    public DtoPlanta obtenerPlantaPorId(int idPlanta) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", idPlanta);
        List<DtoPlanta> list=this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlObtener, paramSource, new MapeoPlanta());
        if(list.size()==1){
            return list.get(0);
        }
        return null;
    }

}














//public class daoPlanta implements RepositorioPlanta {


//    private RepositorioPlantaMysql repoPlanta;
//    @Override
//    public int guardar(Planta planta) {
//        repoPlanta.guardar(planta);
//    }
//
//    @Override
//    public void eliminar(int idPlanta) {
//        repoPlanta.buscarPlantaPorID(idPlanta);
//    }
//
//    @Override
//    public List<Planta> buscarTodos() {
//        return repoPlanta.buscarTodos();
//    }
//
//    @Override
//    public Planta buscarPlantaPorID(int idPlanta) {
//        return null;
//    }
//}
