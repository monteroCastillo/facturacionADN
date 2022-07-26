package com.ceiba.planta.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.planta.comando.ComandoPlanta;
import com.ceiba.planta.comando.manejador.ManejadorActualizarPlanta;
import com.ceiba.planta.comando.manejador.ManejadorCrearPlanta;
import com.ceiba.planta.comando.manejador.ManejadorEliminarPlanta;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/apiPlanta")
@CrossOrigin
public class ComandoControladorPlanta {

    private final ManejadorCrearPlanta manejadorCrearPlanta;

    private final ManejadorEliminarPlanta manejadorEliminarPlanta;

    private final ManejadorActualizarPlanta manejadorActualizarPlanta;

    public ComandoControladorPlanta(ManejadorCrearPlanta manejadorCrearPlanta, ManejadorEliminarPlanta manejadorEliminarPlanta, ManejadorActualizarPlanta manejadorActualizarPlanta) {
        this.manejadorCrearPlanta = manejadorCrearPlanta;
        this.manejadorEliminarPlanta = manejadorEliminarPlanta;
        this.manejadorActualizarPlanta = manejadorActualizarPlanta;
    }


    @PostMapping("/crear")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoPlanta comandoPlanta) {
        return manejadorCrearPlanta.ejecutar(comandoPlanta);
    }

    @DeleteMapping(value="/borrar/{id}")
    public void eliminar(@PathVariable Long id) {
        manejadorEliminarPlanta.ejecutar(id);
    }

    @PutMapping("/actualizar")
    public void actualizar(@RequestBody ComandoPlanta comandoPlanta) {
        manejadorActualizarPlanta.ejecutar(comandoPlanta);
    }


}
