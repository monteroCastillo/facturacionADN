package com.ceiba.proveedor.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.proveedor.servicio.ServicioEliminarProveedor;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarProveedor implements ManejadorComando<Long> {

    private final ServicioEliminarProveedor servicioEliminarProveedor;

    public ManejadorEliminarProveedor(ServicioEliminarProveedor servicioEliminarProveedor) {
        this.servicioEliminarProveedor = servicioEliminarProveedor;
    }


    @Override
    public void ejecutar(Long id) {
        this.servicioEliminarProveedor.ejecutar(id);
    }
}
