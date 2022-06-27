package com.ceiba.plantaporproveedor.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.plantaporproveedor.comando.ComandoSolicitudPlantaPorProveedor;
import com.ceiba.plantaporproveedor.comando.fabrica.FabricaSolicitudPlantaPorProveedor;
import com.ceiba.plantaporproveedor.servicio.ServicioCrearPlantaPorProveedor;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearPlantaPorProveedor implements ManejadorComandoRespuesta<ComandoSolicitudPlantaPorProveedor, ComandoRespuesta<Long>> {


    private final FabricaSolicitudPlantaPorProveedor fabricaSolicitudPlantaPorProveedor;

    private final ServicioCrearPlantaPorProveedor servicioCrearPlantaPorProveedor;



    public ManejadorCrearPlantaPorProveedor(FabricaSolicitudPlantaPorProveedor fabricaSolicitudPlantaPorProveedor, ServicioCrearPlantaPorProveedor servicioCrearPlantaPorProveedor) {
        this.fabricaSolicitudPlantaPorProveedor = fabricaSolicitudPlantaPorProveedor;
        this.servicioCrearPlantaPorProveedor = servicioCrearPlantaPorProveedor;
    }


    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoSolicitudPlantaPorProveedor comandoSolicitudPlantaPorProveedor) {

        return new ComandoRespuesta<>(servicioCrearPlantaPorProveedor
                .ejecutar(fabricaSolicitudPlantaPorProveedor.crear(comandoSolicitudPlantaPorProveedor)));
    }



}
