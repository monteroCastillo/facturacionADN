package com.ceiba.cliente.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.cliente.comando.ComandoCliente;
import com.ceiba.cliente.comando.manejador.ManejadorCrearCliente;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apiCliente")
@CrossOrigin(origins = "http://localhost:4200")
public class ComandoControladorCliente {

    private final ManejadorCrearCliente manejadorCrearCliente;


    public ComandoControladorCliente(ManejadorCrearCliente manejadorCrearCliente) {
        this.manejadorCrearCliente = manejadorCrearCliente;
    }

    @PostMapping("/crear")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoCliente comandoCliente) {
        return manejadorCrearCliente.ejecutar(comandoCliente);
    }

}
