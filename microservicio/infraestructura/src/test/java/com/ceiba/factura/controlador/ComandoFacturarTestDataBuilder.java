package com.ceiba.factura.controlador;

import com.ceiba.factura.comando.ComandoProductoFacturar;
import com.ceiba.factura.comando.ComandoSolicitudFacturar;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class ComandoFacturarTestDataBuilder {
    private LocalDate fechaIngreso;
    private Long id;
    private List<ComandoProductoFacturar> comandoProductosFacturar;
    public ComandoFacturarTestDataBuilder() {
        this.comandoProductosFacturar = new ArrayList<>();
    }
    public ComandoFacturarTestDataBuilder crearPorDefecto() {
        this.id = 111L;
        this.comandoProductosFacturar.add(new ComandoProductoFacturar(12l, 5));
        this.comandoProductosFacturar.add(new ComandoProductoFacturar(13l, 7));
        this.fechaIngreso = LocalDate.of(2022,06,22);
        return this;
    }
    public ComandoSolicitudFacturar build() {
        return new ComandoSolicitudFacturar(this.fechaIngreso, this.id, comandoProductosFacturar);
    }
}
