package com.ceiba.cliente;


import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.cliente.servicio.ServicioCrearCliente;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioCrearClienteTest {
    @Test
    public void validarCreacionCliente(){
        Long ID = 1l;
        Cliente cliente = new ClienteTestDataBuilder().conClientePorDefecto().build();
        RepositorioCliente repositorioCliente = Mockito.mock(RepositorioCliente.class);
        Mockito.when(repositorioCliente.existe(Mockito.anyLong())).thenReturn(false);
        Mockito.when(repositorioCliente.guardar(cliente)).thenReturn(ID);
        ServicioCrearCliente servicioCrearCliente = new ServicioCrearCliente(repositorioCliente);
        // act - assert
        assertEquals(ID,servicioCrearCliente.ejecutar(cliente));

    }
}
