package com.ceiba.cliente;



import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.cliente.servicio.ServicioCrearCliente;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;



public class ServicioCrearClienteTest {

    @Test
    public void validarExistencia() {
        // arrange
        Cliente cliente = new ClienteTestDataBuilder().conClientePorDefecto().reconstruir();

        RepositorioCliente clienteRepositorio = Mockito.mock(RepositorioCliente.class);
        Mockito.when(clienteRepositorio.existe(Mockito.anyLong())).thenReturn(true);
        ServicioCrearCliente serviciocrearCliente = new ServicioCrearCliente(clienteRepositorio);
    }
    
    
//    @Test
//    public void validarCreacionCliente(){
//        Cliente cliente = new ClienteTestDataBuilder()
//                .conClientePorDefecto()
//                .reconstruir();
//        //Long ID = 1l;
//        //Cliente cliente = new ClienteTestDataBuilder().conClientePorDefecto().reconstruir();
//        var  repositorioCliente = Mockito.mock(RepositorioCliente.class);
//        //Mockito.when(repositorioCliente.existe(Mockito.anyLong())).thenReturn(false);
//        Mockito.when(repositorioCliente.guardar(cliente)).thenReturn(1l);
//        var servicioCrearCliente = new ServicioCrearCliente(repositorioCliente);
//        var idCliente = servicioCrearCliente.ejecutar(new SolicitudCrearCliente(cliente));
//        // act - assert
//        assertEquals(1l,idCliente);
//
//    }
}
