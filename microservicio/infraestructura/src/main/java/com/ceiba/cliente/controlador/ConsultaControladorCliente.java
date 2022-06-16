package com.ceiba.cliente.controlador;

import com.ceiba.cliente.comando.manejador.ManejadorBuscarCliente;
import com.ceiba.cliente.modelo.entidad.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ConsultaControladorCliente {

    private final ManejadorBuscarCliente manejadorBuscarCliente;

    public ConsultaControladorCliente(ManejadorBuscarCliente manejadorBuscarCliente) {
        this.manejadorBuscarCliente = manejadorBuscarCliente;
    }

    @GetMapping({"/buscar/{id}"})
    public Cliente buscar(@PathVariable("id") Long id) {
        return this.manejadorBuscarCliente.ejecutar(id);
    }

}
