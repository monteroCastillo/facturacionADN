package com.ceiba.factura.controlador;

import com.ceiba.factura.comando.manejador.ManejadorSumarFacturas;
import com.ceiba.factura.consulta.ManejadorConsultarFacturasAnuladas;
import com.ceiba.factura.modelo.dto.ResumenFacturaDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/factura")
@Tag(name = "Controlador consulta factura")
public class ConsultaControladorFactura {

    private final ManejadorConsultarFacturasAnuladas manejadorConsultarFacturasAnuladas;
    private final ManejadorSumarFacturas manejadorSumarFacturas;

    public ConsultaControladorFactura(ManejadorConsultarFacturasAnuladas manejadorConsultarFacturasAnuladas, ManejadorSumarFacturas manejadorSumarFacturas) {
        this.manejadorConsultarFacturasAnuladas = manejadorConsultarFacturasAnuladas;
        this.manejadorSumarFacturas = manejadorSumarFacturas;
    }

    @GetMapping("anulada")
    @Operation(summary = "Anular", description = "Metodo utilizado para consultar las facturas anuladas")
    public List<ResumenFacturaDTO> obtenerAnuladas() {
        return manejadorConsultarFacturasAnuladas.ejecutar();
    }

    @GetMapping({"/sumarFacturas/{fecha}"})
    public BigDecimal buscarPlantaProveedor(@PathVariable("fecha") String fecha) {
        return this.manejadorSumarFacturas.ejecutar(fecha);
    }
}
