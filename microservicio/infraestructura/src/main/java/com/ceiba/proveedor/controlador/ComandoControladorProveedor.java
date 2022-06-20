package com.ceiba.proveedor.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.proveedor.comando.ComandoProveedor;
import com.ceiba.proveedor.comando.manejador.ManejadorActualizarProveedor;
import com.ceiba.proveedor.comando.manejador.ManejadorCrearProveedor;
import com.ceiba.proveedor.comando.manejador.ManejadorEliminarProveedor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apiProveedor")
@CrossOrigin(origins = "http://localhost:4200")
public class ComandoControladorProveedor {

    private final ManejadorCrearProveedor manejadorCrearProveedor;
    private final ManejadorEliminarProveedor manejadorEliminarProveedor;

    private final ManejadorActualizarProveedor manejadorActualizarProveedor;

    public ComandoControladorProveedor(ManejadorCrearProveedor manejadorCrearProveedor, ManejadorEliminarProveedor manejadorEliminarProveedor, ManejadorActualizarProveedor manejadorActualizarProveedor) {
        this.manejadorCrearProveedor = manejadorCrearProveedor;
        this.manejadorEliminarProveedor = manejadorEliminarProveedor;
        this.manejadorActualizarProveedor = manejadorActualizarProveedor;
    }

    @PostMapping("/guardar")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoProveedor comandoProveedor) {
        return manejadorCrearProveedor.ejecutar(comandoProveedor);
    }

    @DeleteMapping(value="/eliminar/{id}")
    public void eliminar(@PathVariable Long id) {
        manejadorEliminarProveedor.ejecutar(id);
    }

    @PutMapping("/actualizar")
    public void actualizar(@RequestBody ComandoProveedor comandoProveedor) {
        manejadorActualizarProveedor.ejecutar(comandoProveedor);
    }


}

