package com.ceiba.planta.controlador;



import com.ceiba.ComandoRespuesta;
import com.ceiba.planta.comando.ComandoPlanta;
import com.ceiba.planta.comando.manejador.ManejadorCrearPlanta;
import com.ceiba.planta.comando.manejador.ManejadorEliminarPlanta;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apiPlanta")
@CrossOrigin(origins = "http://localhost:4200")
public class ComandoControladorPlanta {

    private final ManejadorCrearPlanta manejadorCrearPlanta;

    private final ManejadorEliminarPlanta manejadorEliminarPlanta;

    public ComandoControladorPlanta(ManejadorCrearPlanta manejadorCrearPlanta, ManejadorEliminarPlanta manejadorEliminarPlanta) {
        this.manejadorCrearPlanta = manejadorCrearPlanta;
        this.manejadorEliminarPlanta = manejadorEliminarPlanta;
    }


    @PostMapping("/crear")
    public ComandoRespuesta<Integer> crear(@RequestBody ComandoPlanta comandoPlanta) {
        return manejadorCrearPlanta.ejecutar(comandoPlanta);
    }

    @DeleteMapping(value="/borrar/{id}")
    public void eliminar(@PathVariable int id) {
        manejadorEliminarPlanta.ejecutar(id);
    }



}
