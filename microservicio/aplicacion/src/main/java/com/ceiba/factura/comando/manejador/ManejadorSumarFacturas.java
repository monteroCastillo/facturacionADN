package com.ceiba.factura.comando.manejador;

import com.ceiba.factura.puerto.dao.DaoFactura;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ManejadorSumarFacturas {

    private final DaoFactura daoFactura;


    public ManejadorSumarFacturas(DaoFactura daoFactura) {
        this.daoFactura = daoFactura;
    }
    public BigDecimal ejecutar(String fecha){
        return this.daoFactura.obtenerSumaFacturas(fecha);
    }
}
