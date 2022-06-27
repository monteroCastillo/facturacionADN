package com.ceiba.plantaporproveedor.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.plantaporproveedor.comando.ComandoPlantaPorProveedor;
import com.ceiba.plantaporproveedor.comando.ComandoSolicitudPlantaPorProveedor;
import com.ceiba.plantaporproveedor.comando.fabrica.FabricaPlantaPorProveedor;
import com.ceiba.plantaporproveedor.modelo.entidad.PlantaPorProveedor;
import com.ceiba.plantaporproveedor.servicio.ServicioCrearPlantaPorProveedor;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearPlantaPorProveedor implements ManejadorComandoRespuesta<ComandoPlantaPorProveedor, ComandoRespuesta<Long>> {


    private final FabricaPlantaPorProveedor fabricaPlantaPorProveedor;

    private final ServicioCrearPlantaPorProveedor servicioCrearPlantaPorProveedor;



    public ManejadorCrearPlantaPorProveedor(FabricaPlantaPorProveedor fabricaPlantaPorProveedor, ServicioCrearPlantaPorProveedor servicioCrearPlantaPorProveedor) {
        this.fabricaPlantaPorProveedor = fabricaPlantaPorProveedor;
        this.servicioCrearPlantaPorProveedor = servicioCrearPlantaPorProveedor;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoPlantaPorProveedor comando) {
        PlantaPorProveedor plantaPorProveedor = this.fabricaPlantaPorProveedor.crear(comando);
        return new ComandoRespuesta<>(this.servicioCrearPlantaPorProveedor.ejecutar(plantaPorProveedor));
    }
}
