package com.ceiba.PlantaPorProveedor.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.plantaporproveedor.comando.ComandoSolicitudPlantaPorProveedor;
import com.ceiba.plantaporproveedor.comando.manejador.ManejadorCrearPlantaPorProveedor;
import com.ceiba.plantaporproveedor.comando.manejador.ManejadorEliminarPlantaPorProveedor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apiPlantaPorProveedor")
@CrossOrigin(origins = "http://localhost:4200")
public class ComandoControladorPlantaPorProveedor {

    private final ManejadorCrearPlantaPorProveedor manejadorCrearPlantaPorProveedor;
    private final ManejadorEliminarPlantaPorProveedor manejadorEliminarPlantaPorProveedor;

    public ComandoControladorPlantaPorProveedor(ManejadorCrearPlantaPorProveedor manejadorCrearPlantaPorProveedor, ManejadorEliminarPlantaPorProveedor manejadorEliminarPlantaPorProveedor) {
        this.manejadorCrearPlantaPorProveedor = manejadorCrearPlantaPorProveedor;
        this.manejadorEliminarPlantaPorProveedor = manejadorEliminarPlantaPorProveedor;
    }

    @PostMapping("/guardar")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoSolicitudPlantaPorProveedor comandoSolicitudPlantaPorProveedor) {
        return this.manejadorCrearPlantaPorProveedor.ejecutar(comandoSolicitudPlantaPorProveedor);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Long id){
        manejadorEliminarPlantaPorProveedor.ejecutar(id);
    }
}
