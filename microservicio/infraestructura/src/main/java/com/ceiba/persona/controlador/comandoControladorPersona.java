package com.ceiba.persona.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.persona.comando.ComandoSolicitudCrear;
import com.ceiba.persona.adaptador.repositorio.RepositorioPersonaMysql;
import com.ceiba.persona.modelo.entidad.Persona;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/apiPersona")
public class comandoControladorPersona {

    @Autowired
    private RepositorioPersonaMysql servicioPersona;

    @GetMapping({"/persona/{id}"})
    public Persona buscarTodos(@PathVariable("id") Long idPersona) {
        return servicioPersona.buscarPersonaPorID(idPersona);
    }

    @PostMapping({"/persona"})
    public Long guardar(@RequestBody Persona persona) {
       return servicioPersona.guardar(persona);

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
