package com.ceiba.proveedor.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.proveedor.comando.ComandoProveedor;
import com.ceiba.proveedor.comando.fabrica.FabricaProveedor;
import com.ceiba.proveedor.modelo.entidad.Proveedor;
import com.ceiba.proveedor.servicio.ServicioCrearProveedor;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearProveedor  implements ManejadorComandoRespuesta<ComandoProveedor, ComandoRespuesta<Long>> {

    private final ServicioCrearProveedor servicioCrearProveedor;

    private final FabricaProveedor fabricaProveedor;

    public ManejadorCrearProveedor(ServicioCrearProveedor servicioCrearProveedor, FabricaProveedor fabricaProveedor) {
        this.servicioCrearProveedor = servicioCrearProveedor;
        this.fabricaProveedor = fabricaProveedor;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoProveedor comando) {
        Proveedor proveedor = this.fabricaProveedor.crear(comando);

        return new ComandoRespuesta<>(this.servicioCrearProveedor.ejecutar(proveedor));
    }
}
