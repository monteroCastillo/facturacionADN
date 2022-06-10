package com.ceiba;

import com.ceiba.persona.adaptador.repositorio.RepositorioPersonaJpa;
import com.ceiba.persona.modelo.entidad.Persona;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
@DataJpaTest
@SpringBootTest
public class PersonaTest {

    @Autowired
    public RepositorioPersonaJpa personaRepository;

    public PersonaTest() {
    }

    @Test
    void testNombrePersona(){
        Persona persona = new Persona();
        persona.setNombre("Andres");
        String esperado = "Andres";
        String real = persona.getNombre();
        Assertions.assertEquals(esperado, real); //Esta es la clase que realmente hace la comprobación

    }

    @Test
    void testFindById() {
        Optional<Persona> persona = this.personaRepository.findById(123L);
        Assertions.assertTrue(persona.isPresent());
        Assertions.assertEquals("Shi", ((Persona)persona.orElseThrow()).getNombre());
    }

    @Test
    void testFindByPersona() {
        Optional<Persona> persona = this.personaRepository.findByPersona("Shi");
        Assertions.assertTrue(persona.isPresent());
        Assertions.assertEquals("Shi", ((Persona)persona.orElseThrow()).getNombre());
        Assertions.assertEquals("4545456", ((Persona)persona.orElseThrow()).getTelefono());
    }

    @Test
    void testFindByPersonaThrowException() {
        Optional<Persona> persona = this.personaRepository.findByPersona("Negro");
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            persona.orElseThrow();
        });
        Assertions.assertFalse(persona.isPresent());
    }

    @Test
    void testFindAll() {
        List<Persona> persona = this.personaRepository.findAll();
        Assertions.assertFalse(persona.isEmpty());
        Assertions.assertEquals(2, persona.size());
    }

    @Test
    void testSave() {
        Persona personaNueva = new Persona(333L, "Pedro", "Av 6", "4545456", "shi@gmail.com", LocalDate.of(2022, 5, 22));
        this.personaRepository.save(personaNueva);
        Persona persona = (Persona)this.personaRepository.findByPersona("Pedro").orElseThrow();
        Assertions.assertEquals("Pedro", persona.getNombre());
        Assertions.assertEquals("4545456", persona.getTelefono());
    }
}
