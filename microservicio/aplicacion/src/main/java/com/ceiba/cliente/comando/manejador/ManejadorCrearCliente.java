package com.ceiba.cliente.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.cliente.comando.ComandoCliente;
import com.ceiba.cliente.comando.fabrica.FabricaCliente;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.servicio.ServicioCrearCliente;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearCliente implements ManejadorComandoRespuesta<ComandoCliente, ComandoRespuesta<Long>> {

    private final ServicioCrearCliente servicioCrearCliente;

    private final FabricaCliente fabricaCliente;

    public ManejadorCrearCliente(ServicioCrearCliente servicioCrearCliente, FabricaCliente fabricaCliente) {
        this.servicioCrearCliente = servicioCrearCliente;
        this.fabricaCliente = fabricaCliente;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoCliente comando) {
        Cliente cliente = this.fabricaCliente.crear(comando);
        return  new ComandoRespuesta<>(this.servicioCrearCliente.ejecutar(cliente));
    }
}
