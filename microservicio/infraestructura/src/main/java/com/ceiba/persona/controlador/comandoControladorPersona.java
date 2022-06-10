package com.ceiba.persona.controlador;

import com.ceiba.persona.modelo.entidad.Persona;
import com.ceiba.persona.puerto.repositorio.RepositorioPersona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apiPersona")
public class comandoControladorPersona {

    @Autowired
    private RepositorioPersona servicioPersona;

    @GetMapping({"/index"})
    public List<Persona> buscarTodos() {
        return servicioPersona.buscarTodos();
    }

    @PostMapping({"/persona"})
    public Persona guardar(@RequestBody Persona persona) {
        servicioPersona.guardar(persona);
        return persona;
    }

    @PutMapping({"/persona"})
    public Persona modificar(@RequestBody Persona persona) {
        servicioPersona.guardar(persona);
        return persona;
    }

    @DeleteMapping({"/persona/{id}"})
    public String eliminar(@PathVariable("id") Long idPersona) {
        servicioPersona.eliminar((Long)idPersona);
        return "Registro de Persona eliminada!";
    }
}
