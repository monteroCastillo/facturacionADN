package com.ceiba.empleado;


import com.ceiba.empleado.modelo.entidad.Empleado;
import com.ceiba.empleado.modelo.entidad.SolicitudCrearEmpleado;
import com.ceiba.empleado.puerto.repositorio.RepositorioEmpleado;
import com.ceiba.empleado.servicio.ServicioCrearEmpleado;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioCrearEmpleadoTest {

    @Test
    public void validarCreacionEmpleado(){
        Long ID = 1l;
        Empleado empleado = new EmpleadoTestDataBuilder().conEmpleadoPorDefecto().reconstruir();

        var repositorioEmpleado = Mockito.mock(RepositorioEmpleado.class);
        Mockito.when(repositorioEmpleado.guardar(Mockito.any())).thenReturn(1l);


        var servicioCrearEmpleado = new ServicioCrearEmpleado(repositorioEmpleado);

        var idEmpleado = repositorioEmpleado.guardar(empleado);
        // act - assert
        assertEquals(1l,idEmpleado);

    }
}
