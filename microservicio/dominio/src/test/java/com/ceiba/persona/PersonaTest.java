package com.ceiba.persona;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.persona.modelo.entidad.Persona;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class PersonaTest {


    @Test
    void testNombrePersona(){
        Persona persona = new Persona();
        persona.setNombre("Andres");
        String esperado = "Andres";
        String real = persona.getNombre();
        Assertions.assertEquals(esperado, real); //Esta es la clase que realmente hace la comprobación

    }

    @Test
    void deberiaReconstruirPersonaExitosamente() {

        var persona = new PersonaTestDataBuilder().conId(123l)
                .conNombre("Shirly")
                .conDireccion("Av 5")
                .conTelefono("12345").reconstruir();

        Assertions.assertEquals(123l, persona.getIdPersona());
        Assertions.assertEquals("Shirly", persona.getNombre());
        Assertions.assertEquals("Av 5", persona.getDireccion());
        Assertions.assertEquals("12345", persona.getTelefono());
    }
}
