package com.ceiba.factura.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.factura.comando.ComandoAnular;
import com.ceiba.factura.comando.ComandoSolicitudFacturar;
import com.ceiba.factura.comando.manejador.ManejadorAnular;
import com.ceiba.factura.comando.manejador.ManejadorFacturar;
import com.ceiba.factura.comando.manejador.ManejadorMostrarFacturas;
import com.ceiba.factura.modelo.entidad.Factura;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/factura")
@Tag(name = "Controlador comando factura")
public class ComandoControladorFactura {

    private final ManejadorFacturar manejadorFacturar;
    private final ManejadorAnular manejadorAnular;

    private final ManejadorMostrarFacturas manejadorMostrarFacturas;

    public ComandoControladorFactura(ManejadorFacturar manejadorFacturar, ManejadorAnular manejadorAnular, ManejadorMostrarFacturas manejadorMostrarFacturas) {
        this.manejadorFacturar = manejadorFacturar;
        this.manejadorAnular = manejadorAnular;
        this.manejadorMostrarFacturas = manejadorMostrarFacturas;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/guardar")
    @Operation(summary = "Facturar", description = "Metodo utilizado para crear una nueva factura")
    public ComandoRespuesta<Long> facturar(@RequestBody ComandoSolicitudFacturar comandoSolicitudFacturar) {
        return this.manejadorFacturar.ejecutar(comandoSolicitudFacturar);
    }

    @PostMapping("anular/{id-factura}")
    @Operation(summary = "Anular", description = "Metodo utilizado para anular una nueva factura")
    public void anular(@PathVariable("id-factura") Long idFactura) {
        this.manejadorAnular.ejecutar(new ComandoAnular(idFactura));
    }

    @GetMapping({"/buscar/{id}"})
    public Factura buscar(@PathVariable("id") Long id) {
        return this.manejadorMostrarFacturas.ejecutar(id);
    }


}
