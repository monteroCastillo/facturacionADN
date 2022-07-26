package com.ceiba.factura.adaptador.repositorio;

import com.ceiba.factura.modelo.entidad.ProductoFacturar;
import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.planta.puerto.dao.DaoPlanta;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MapeoProductoFacturar implements RowMapper<ProductoFacturar>, MapperResult {

    private final DaoPlanta daoPlanta;

    public MapeoProductoFacturar(DaoPlanta daoPlanta) {
        this.daoPlanta = daoPlanta;
    }


    @Override
    public ProductoFacturar mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        var id = resultSet.getLong("id");
        var idPlanta = resultSet.getLong("id_planta");
        var cantidad = resultSet.getInt("cantidad");

        return ProductoFacturar.reconstruir(id, cantidad, daoPlanta.obtener(idPlanta));
    }

}
