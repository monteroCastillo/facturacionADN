package com.ceiba.Empleado;

import com.ceiba.Empleado.modelo.entidad.Empleado;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class EmpleadoTest {


    @Test
    void testNombrePersona(){
        Empleado empleado = new Empleado();
        empleado.setNombre("Andres");
        String esperado = "Andres";
        String real = empleado.getNombre();
        Assertions.assertEquals(esperado, real);

    }

//    @Test
//    void deberiaReconstruirPersonaExitosamente() {
//
//        var persona = new PersonaTestDataBuilder().conId(123l)
//                .conNombre("Shirly")
//                .conDireccion("Av 5")
//                .conTelefono("12345").reconstruir();
//
//        Assertions.assertEquals(123l, persona.getIdPersona());
//        Assertions.assertEquals("Shirly", persona.getNombre());
//        Assertions.assertEquals("Av 5", persona.getDireccion());
//        Assertions.assertEquals("12345", persona.getTelefono());
//    }
}
