package com.ceiba.empleado;

import com.ceiba.empleado.modelo.entidad.Empleado;
import com.ceiba.empleado.modelo.entidad.Perfil;
import com.ceiba.empleado.puerto.repositorio.RepositorioEmpleado;
import com.ceiba.empleado.servicio.ServicioCrearEmpleado;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.time.LocalDate;

public class SolicitudCrearEmpleadoTest {
    @Test
    void deberiaReconstruirunEmpleadoExitosamente() {
        Empleado empleado = new EmpleadoTestDataBuilder()
                .conEmpleadoPorDefecto()
                .reconstruir();

        var solicitudCrearEmpleado = new SolicitudCrearEmpleadoTestDataBuilder()
                .conId(123l)
                .conNombre("Shirly")
                .conDireccion("Av 5")
                .conTelefono("12345")
                .conEmail("shi@gmail.com")
                .conFechaRegistro( LocalDate.now())
                .conPerfil(Perfil.valueOf("ADMINISTRADOR")).
                construir();
        var repositorioEmpleado = Mockito.mock(RepositorioEmpleado.class);
        Mockito.when(repositorioEmpleado.guardar(Mockito.any())).thenReturn(123L);

        var servicioEmpleado = new ServicioCrearEmpleado(repositorioEmpleado);
        var idEmpleadoGuardado = servicioEmpleado.ejecutar(solicitudCrearEmpleado);

        ArgumentCaptor<Empleado> captorEmpleado = ArgumentCaptor.forClass(Empleado.class);
        Mockito.verify(repositorioEmpleado,  Mockito.times(1)).guardar(captorEmpleado.capture());

        Assertions.assertEquals(123l, idEmpleadoGuardado);
        Assertions.assertEquals("Shirly", captorEmpleado.getValue().getNombre());
        Assertions.assertEquals("Av 5", captorEmpleado.getValue().getDireccion());
        Assertions.assertEquals("12345", captorEmpleado.getValue().getTelefono());
        Assertions.assertEquals("shi@gmail.com", captorEmpleado.getValue().getEmail());
        Assertions.assertEquals(LocalDate.now(), captorEmpleado.getValue().getFechaRegistro());
        Assertions.assertEquals(Perfil.valueOf("ADMINISTRADOR"), captorEmpleado.getValue().getPerfil());

    }
}
