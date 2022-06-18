package com.ceiba.plantaporproveedor.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.PlantaPorProveedor.modelo.entidad.PlantaPorProveedor;
import com.ceiba.PlantaPorProveedor.servicio.ServicioCrearPlantaPorProveedor;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.plantaporproveedor.comando.ComandoPlantaPorProveedor;
import com.ceiba.plantaporproveedor.comando.fabrica.FabricaPlantaPorProveedor;
import com.ceiba.proveedor.comando.ComandoProveedor;
import com.ceiba.proveedor.modelo.entidad.Proveedor;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearPlantaPorProveedor implements ManejadorComandoRespuesta<ComandoPlantaPorProveedor, ComandoRespuesta<Long>> {


    private final ServicioCrearPlantaPorProveedor servicioCrearPlantaPorProveedor;

    private final FabricaPlantaPorProveedor fabricaPlantaPorProveedor;

    public ManejadorCrearPlantaPorProveedor(ServicioCrearPlantaPorProveedor servicioCrearPlantaPorProveedor, FabricaPlantaPorProveedor fabricaPlantaPorProveedor) {
        this.servicioCrearPlantaPorProveedor = servicioCrearPlantaPorProveedor;
        this.fabricaPlantaPorProveedor = fabricaPlantaPorProveedor;
    }


    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoPlantaPorProveedor comando) {
        PlantaPorProveedor plantaPorProveedor = this.fabricaPlantaPorProveedor.crear(comando);

        return new ComandoRespuesta<>(this.servicioCrearPlantaPorProveedor.ejecutar(plantaPorProveedor));
    }
}
