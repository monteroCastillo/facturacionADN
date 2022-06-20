package com.ceiba.empleado;

import com.ceiba.BasePrueba;
import com.ceiba.empleado.modelo.entidad.Empleado;
import com.ceiba.empleado.modelo.entidad.Perfil;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;


public class EmpleadoTest {


    @Test
    void testNombrePersona(){
        Empleado empleado = new Empleado();
        empleado.setNombre("Andres");
        String esperado = "Andres";
        String real = empleado.getNombre();
        Assertions.assertEquals(esperado, real);

    }

    @Test
    void deberiaReconstruirPersonaExitosamente() {

        var persona = new EmpleadoTestDataBuilder()
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

    @Test
    void reconstruirSinIddeberiaDeberiaLanzarError() {
        BasePrueba.assertThrows(() -> new EmpleadoTestDataBuilder()
                .conNombre("Shirly")
                .conDireccion("Av 5")
                .conTelefono("12345")
                .conEmail("shi@gmail.com")
                .conFechaRegistro(LocalDate.of(2022,05,22))
                .conPerfil(Perfil.valueOf("ADMINISTRADOR")).
                reconstruir(), ExcepcionValorObligatorio.class,
                "El id del empleado es requerido");
    }

    @Test
    void reconstruirSinNombredeberiaDeberiaLanzarError() {
        BasePrueba.assertThrows(() -> new EmpleadoTestDataBuilder()
                        .conId(123l)
                        .conDireccion("Av 5")
                        .conTelefono("12345")
                        .conEmail("shi@gmail.com")
                        .conFechaRegistro(LocalDate.of(2022,05,22))
                        .conPerfil(Perfil.valueOf("ADMINISTRADOR")).
                        reconstruir(), ExcepcionValorObligatorio.class,
                "El nombre del empleado es requerido");
    }

    @Test
    void reconstruirSinDirecciondeberiaDeberiaLanzarError() {
        BasePrueba.assertThrows(() -> new EmpleadoTestDataBuilder()
                        .conId(123l)
                        .conNombre("Shirly")
                        .conTelefono("12345")
                        .conEmail("shi@gmail.com")
                        .conFechaRegistro(LocalDate.of(2022,05,22))
                        .conPerfil(Perfil.valueOf("ADMINISTRADOR")).
                        reconstruir(), ExcepcionValorObligatorio.class,
                "La direccion del empleado es requerida");
    }
    @Test
    void reconstruirSinTelefonodeberiaDeberiaLanzarError() {
        BasePrueba.assertThrows(() -> new EmpleadoTestDataBuilder()
                        .conId(123l)
                        .conNombre("Shirly")
                        .conDireccion("Av 5")
                        .conEmail("shi@gmail.com")
                        .conFechaRegistro(LocalDate.of(2022,05,22))
                        .conPerfil(Perfil.valueOf("ADMINISTRADOR")).
                        reconstruir(), ExcepcionValorObligatorio.class,
                "El telefono del empleado es requerido");
    }


}
