package com.ceiba.empleado;


import com.ceiba.empleado.modelo.entidad.Empleado;
import com.ceiba.empleado.puerto.repositorio.RepositorioEmpleado;
import com.ceiba.empleado.servicio.ServicioCrearEmpleado;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioCrearEmpleadoTest {

    @Test
    public void validarCreacionEmpleado(){
        Long ID = 1l;
        Empleado empleado = new EmpleadoTestDataBuilder().conEmpleadoPorDefecto().build();
        RepositorioEmpleado repositorioEmpleado = Mockito.mock(RepositorioEmpleado.class);
        Mockito.when(repositorioEmpleado.existe(Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioEmpleado.guardar(empleado)).thenReturn(ID);
        ServicioCrearEmpleado servicioCrearEmpleado = new ServicioCrearEmpleado(repositorioEmpleado);
        // act - assert
        assertEquals(ID,servicioCrearEmpleado.ejecutar(empleado));

    }
}
