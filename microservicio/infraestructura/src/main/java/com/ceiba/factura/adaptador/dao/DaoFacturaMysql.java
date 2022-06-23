package com.ceiba.factura.adaptador.dao;

import com.ceiba.factura.modelo.dto.ResumenFacturaDTO;
import com.ceiba.factura.puerto.dao.DaoFactura;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.planta.adaptador.dao.MapeoPlanta;
import com.ceiba.planta.modelo.entidad.Planta;
import com.fasterxml.jackson.core.io.BigDecimalParser;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class DaoFacturaMysql implements DaoFactura {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private final MapeoFacturaResumen mapeoFacturaResumen;

    @SqlStatement(namespace = "factura", value = "obteneranuladas")
    private static String sqlObtenerAnuladas;

    @SqlStatement(namespace = "factura", value = "obtenersumafactura")
    private static String sqlObtenerSumaFactura;

    public DaoFacturaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoFacturaResumen mapeoFacturaResumen) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoFacturaResumen = mapeoFacturaResumen;
    }

    @Override
    public List<ResumenFacturaDTO> obtenerResumenDeFacturasAnuladas() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .query(sqlObtenerAnuladas, mapeoFacturaResumen);
    }

    @Override
    public BigDecimal obtenerSumaFacturas(String fecha) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("fecha", fecha);
        System.out.println("DATO QUE LE ENTRA A LA CONSULTA: " + paramSource);
        return  this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlObtenerSumaFactura, paramSource, BigDecimal.class);
    }

    public List<Planta> plantaProveedor(Long proveedor) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", proveedor);
        System.out.println("DATO QUE LE ENTRA A LA CONSULTA: " + paramSource);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlObtenerSumaFactura, paramSource, new MapeoPlanta());
    }

}
