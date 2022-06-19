package com.ceiba.PlantaPorProveedor.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.plantaporproveedor.comando.ComandoPlantaPorProveedor;
import com.ceiba.plantaporproveedor.comando.ComandoSolicitudPlantaPorProveedor;
import com.ceiba.plantaporproveedor.comando.manejador.ManejadorCrearPlantaPorProveedor;
import com.ceiba.proveedor.comando.ComandoProveedor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apiPlantaPorProveedor")
@CrossOrigin(origins = "http://localhost:4200")
public class ComandoControladorPlantaPorProveedor {

    private final ManejadorCrearPlantaPorProveedor manejadorCrearPlantaPorProveedor;


    public ComandoControladorPlantaPorProveedor(ManejadorCrearPlantaPorProveedor manejadorCrearPlantaPorProveedor) {
        this.manejadorCrearPlantaPorProveedor = manejadorCrearPlantaPorProveedor;
    }

    @PostMapping("/guardar")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoSolicitudPlantaPorProveedor comandoSolicitudPlantaPorProveedor) {
        return this.manejadorCrearPlantaPorProveedor.ejecutar(comandoSolicitudPlantaPorProveedor);
    }

//    @PostMapping("/guardar")
//    public ComandoRespuesta<Long> crear(@RequestBody ComandoPlantaPorProveedor comandoPlantaPorProveedor) {
//        return manejadorCrearPlantaPorProveedor.ejecutar(comandoPlantaPorProveedor);
//    }
}
