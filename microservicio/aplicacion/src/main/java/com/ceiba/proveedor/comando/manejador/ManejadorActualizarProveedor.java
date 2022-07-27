package com.ceiba.proveedor.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.proveedor.comando.ComandoProveedor;
import com.ceiba.proveedor.comando.fabrica.FabricaActualizarProveedor;
import com.ceiba.proveedor.servicio.ServicioActualizarProveedor;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarProveedor implements ManejadorComando<ComandoProveedor> {

    private final FabricaActualizarProveedor fabricaActualizarProveedor;
    private final ServicioActualizarProveedor servicioActualizarProveedor;

    public ManejadorActualizarProveedor(FabricaActualizarProveedor fabricaActualizarProveedor, ServicioActualizarProveedor servicioActualizarProveedor) {
        this.fabricaActualizarProveedor = fabricaActualizarProveedor;
        this.servicioActualizarProveedor = servicioActualizarProveedor;
    }

    @Override
    public void ejecutar(ComandoProveedor comandoProveedor)  {

        this.servicioActualizarProveedor.ejecutar(fabricaActualizarProveedor.actualizarProveedor(comandoProveedor));

    }
}
