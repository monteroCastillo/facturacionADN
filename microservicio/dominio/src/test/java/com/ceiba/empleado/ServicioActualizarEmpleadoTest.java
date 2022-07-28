package com.ceiba.empleado;

import com.ceiba.empleado.modelo.entidad.Empleado;
import com.ceiba.empleado.puerto.repositorio.RepositorioEmpleado;
import com.ceiba.empleado.servicio.ServicioActualizarEmpleado;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;

public class ServicioActualizarEmpleadoTest {
    @Test
    public void validarActualizacionEmpleadoTest() {

        // arrange
        Empleado empleado = new EmpleadoTestDataBuilder().conEmpleadoPorDefecto().reconstruir();

        var repositorioEmpleado = Mockito.mock(RepositorioEmpleado.class);

        Mockito.when(repositorioEmpleado.guardar(Mockito.any())).thenReturn(1L);
        ServicioActualizarEmpleado servicioActualizarEmpleado = new ServicioActualizarEmpleado(repositorioEmpleado);
        // act - assert
        repositorioEmpleado.actualizar(empleado);
        Mockito.verify(repositorioEmpleado,times(1)).actualizar(empleado);
    }
}
