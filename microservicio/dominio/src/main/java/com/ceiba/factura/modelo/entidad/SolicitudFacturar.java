package com.ceiba.factura.modelo.entidad;


import com.ceiba.cliente.modelo.entidad.Cliente;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
@AllArgsConstructor
public class SolicitudFacturar {
    private final LocalDate fechaIngreso;
    private final Cliente cliente;
    private final List<ProductoFacturar> productosFacturar;


}
