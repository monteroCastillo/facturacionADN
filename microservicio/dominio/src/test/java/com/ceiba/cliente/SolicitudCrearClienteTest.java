package com.ceiba.cliente;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.modelo.entidad.TipoCliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.cliente.servicio.ServicioCrearCliente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

public class SolicitudCrearClienteTest {

    @Test
    void deberiaCrearUnaSolicitudDeClienteCorrectamente(){
        Cliente cliente = new ClienteTestDataBuilder()
                .conClientePorDefecto()
                .reconstruir();

        var solicitudCrearCliente = new SolicitudCrearClienteTestDataBuilder()
                .conId(1l)
                .conNombre("Cliente 1")
                .conDireccion("Av 6")
                .conTelefono("55555")
                .conEmail("cliente@gmail.com")
                .conTipoCliente(TipoCliente.COMUN)
                .construir();

        var repositorioCliente = Mockito.mock(RepositorioCliente.class);
        Mockito.when(repositorioCliente.guardar(Mockito.any())).thenReturn(1L);

        var servicioCliente = new ServicioCrearCliente(repositorioCliente);
        var idClienteGuardado = servicioCliente.ejecutar(solicitudCrearCliente);

        ArgumentCaptor<Cliente> captorCliente = ArgumentCaptor.forClass(Cliente.class);
        Mockito.verify(repositorioCliente,  Mockito.times(1)).guardar(captorCliente.capture());

        Assertions.assertEquals(1l, idClienteGuardado);
        Assertions.assertEquals("Cliente 1", captorCliente.getValue().getNombre());
        Assertions.assertEquals("Av 6", captorCliente.getValue().getDireccion());
        Assertions.assertEquals("55555", captorCliente.getValue().getTelefono());
        Assertions.assertEquals("cliente@gmail.com", captorCliente.getValue().getEmail());
        Assertions.assertEquals(TipoCliente.COMUN, captorCliente.getValue().getTipoCliente());

    }

}
