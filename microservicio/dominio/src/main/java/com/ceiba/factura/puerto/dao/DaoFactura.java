package com.ceiba.factura.puerto.dao;

import com.ceiba.factura.modelo.dto.ResumenFacturaDTO;
import java.math.BigDecimal;
import java.util.List;

public interface DaoFactura {

    List<ResumenFacturaDTO> obtenerResumenDeFacturasAnuladas();
    BigDecimal obtenerSumaFacturas(String fecha);
}
