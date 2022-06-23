package com.ceiba.factura.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoSolicitudFacturar {
    private LocalDate fechaIngreso;
    private Long idCliente;
    private List<ComandoProductoFacturar> comandoProductosFacturar;
}
