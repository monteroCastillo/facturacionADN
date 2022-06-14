package com.ceiba.persona.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.persona.adaptador.repositorio.RepositorioPersonaMysql;
import com.ceiba.persona.comando.ComandoPersona;
import com.ceiba.persona.comando.manejador.ManejadorCrearPersona;
import com.ceiba.persona.modelo.entidad.Persona;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apiPersona")
public class comandoControladorPersona {

    private final ManejadorCrearPersona manejadorCrearPersona;




    public comandoControladorPersona(ManejadorCrearPersona manejadorCrearPersona) {
        this.manejadorCrearPersona = manejadorCrearPersona;
    }

//    @GetMapping({"/persona/{id}"})
//    public Persona buscarTodos(@PathVariable("id") Long idPersona) {
//        return servicioPersona.buscarPersonaPorID(idPersona);
//    }

    @PostMapping({"/persona"})
    public ComandoRespuesta<Long> guardar(@RequestBody ComandoPersona comandoPersona) {
       return manejadorCrearPersona.ejecutar(comandoPersona);

    }

//    @ResponseStatus(HttpStatus.CREATED)
//    @PostMapping("/persona")
//    @Operation(summary = "crear", description = "Metodo utilizado para crear una nueva factura")
//    public ComandoRespuesta<Long> guardar(@RequestBody ComandoSolicitudCrear comandoSolicitudcrear) {
//        return this.manejador.ejecutar(comandoSolicitudcrear);
//    }

//
//    @PutMapping({"/persona"})
//    public Persona modificar(@RequestBody Persona persona) {
//        servicioPersona.guardar(persona);
//        return persona;
//    }
//
//    @DeleteMapping({"/persona/{id}"})
//    public String eliminar(@PathVariable("id") Long idPersona) {
//        servicioPersona.eliminar((Long)idPersona);
//        return "Registro de Persona eliminada!";
//    }
}
