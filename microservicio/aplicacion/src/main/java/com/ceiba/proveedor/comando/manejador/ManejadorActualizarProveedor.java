package com.ceiba.proveedor.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.proveedor.comando.ComandoProveedor;
import com.ceiba.proveedor.comando.fabrica.FabricaProveedor;
import com.ceiba.proveedor.modelo.entidad.Proveedor;
import com.ceiba.proveedor.servicio.ServicioActualizarProveedor;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarProveedor implements ManejadorComando<ComandoProveedor> {

    private final FabricaProveedor fabricaProveedor;

    private final ServicioActualizarProveedor servicioActualizarProveedor;

    public ManejadorActualizarProveedor(FabricaProveedor fabricaProveedor, ServicioActualizarProveedor servicioActualizarProveedor) {
        this.fabricaProveedor = fabricaProveedor;
        this.servicioActualizarProveedor = servicioActualizarProveedor;
    }

    @Override
    public void ejecutar(ComandoProveedor comandoProveedor)  {
        Proveedor proveedor = this.fabricaProveedor.crear(comandoProveedor);
        this.servicioActualizarProveedor.ejecutar(proveedor);

    }
}
