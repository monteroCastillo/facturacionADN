package com.ceiba.factura.controlador;

import com.ceiba.factura.comando.manejador.ManejadorSumarFacturas;
import com.ceiba.factura.consulta.ManejadorConsultarFacturasAnuladas;
import com.ceiba.factura.modelo.dto.ResumenFacturaDTO;
import com.ceiba.planta.modelo.entidad.Planta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

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

    @GetMapping({"/sumarFacturas/{id}"})
    public BigDecimal buscarPlantaProveedor(@PathVariable("id") String fecha) {
        return this.manejadorSumarFacturas.ejecutar(fecha);
    }
}
