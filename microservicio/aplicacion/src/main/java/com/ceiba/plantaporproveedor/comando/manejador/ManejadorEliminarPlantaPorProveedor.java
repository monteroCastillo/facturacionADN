package com.ceiba.plantaporproveedor.comando.manejador;

import com.ceiba.PlantaPorProveedor.servicio.ServicioEliminarPlantaPorProveedor;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarPlantaPorProveedor implements ManejadorComando<Long> {

    private final ServicioEliminarPlantaPorProveedor servicioEliminarPlantaPorProveedor;

    public ManejadorEliminarPlantaPorProveedor(ServicioEliminarPlantaPorProveedor servicioEliminarPlantaPorProveedor) {
        this.servicioEliminarPlantaPorProveedor = servicioEliminarPlantaPorProveedor;
    }

    @Override
    public void ejecutar(Long id) {this.servicioEliminarPlantaPorProveedor.ejecutar(id);

    }
}
