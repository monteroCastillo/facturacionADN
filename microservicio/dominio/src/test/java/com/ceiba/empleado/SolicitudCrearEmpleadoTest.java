package com.ceiba.empleado;

import com.ceiba.empleado.modelo.entidad.Perfil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class SolicitudCrearEmpleadoTest {
    @Test
    void deberiaReconstruirPersonaExitosamente() {

        var persona = new SolicitudCrearEmpleadoTestDataBuilder()
                .conId(123l)
                .conNombre("Shirly")
                .conDireccion("Av 5")
                .conTelefono("12345")
                .conEmail("shi@gmail.com")
                .conFechaRegistro( LocalDate.now())
                .conPerfil(Perfil.valueOf("ADMINISTRADOR")).
                reconstruir();

        Assertions.assertEquals(123l, persona.getIdEmpleado());
        Assertions.assertEquals("Shirly", persona.getNombre());
        Assertions.assertEquals("Av 5", persona.getDireccion());
        Assertions.assertEquals("12345", persona.getTelefono());
        Assertions.assertEquals("shi@gmail.com", persona.getEmail());
        Assertions.assertEquals(LocalDate.now(), persona.getFechaRegistro());
        Assertions.assertEquals(Perfil.valueOf("ADMINISTRADOR"), persona.getPerfil());
    }
}
