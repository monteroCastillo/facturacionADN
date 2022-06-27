package com.ceiba.cliente;

import com.ceiba.BasePrueba;
import com.ceiba.cliente.modelo.entidad.TipoCliente;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ClienteTest {

    @Test
    void deberiaReconstruirClienteExitosamente() {
        var cliente = new ClienteTestDataBuilder()
                .conId(1l)
                .conNombre("Cliente 1")
                .conDireccion("Av 6")
                .conTelefono("55555")
                .conEmail("cliente@gmail.com")
                .conTipoCliente(TipoCliente.COMUN)
                .reconstruir();

        Assertions.assertEquals(1l, cliente.getId());
        Assertions.assertEquals("Cliente 1", cliente.getNombre());
        Assertions.assertEquals("Av 6", cliente.getDireccion());
        Assertions.assertEquals("55555", cliente.getTelefono());
        Assertions.assertEquals("cliente@gmail.com", cliente.getEmail());
        Assertions.assertEquals(TipoCliente.COMUN, cliente.getTipoCliente());

    }

    @Test
    void deberiaReconstruirClienteExitosamenteValidandoTipoClientePreferencial() {
        var cliente = new ClienteTestDataBuilder()
                .conId(1l)
                .conNombre("Cliente 1")
                .conDireccion("Av 6")
                .conTelefono("55555")
                .conEmail("cliente@gmail.com")
                .conTipoCliente(TipoCliente.PREFERENCIAL)
                .reconstruir();

        Assertions.assertEquals(1l, cliente.getId());
        Assertions.assertEquals("Cliente 1", cliente.getNombre());
        Assertions.assertEquals("Av 6", cliente.getDireccion());
        Assertions.assertEquals("55555", cliente.getTelefono());
        Assertions.assertEquals("cliente@gmail.com", cliente.getEmail());
        Assertions.assertEquals(TipoCliente.PREFERENCIAL, cliente.getTipoCliente());
    }

    @Test
    void deberiaReconstruirClienteExitosamenteValidandoTipoCliente() {
        var cliente = new ClienteTestDataBuilder()
                .conId(1l)
                .conNombre("Cliente 1")
                .conDireccion("Av 6")
                .conTelefono("55555")
                .conEmail("cliente@gmail.com")
                .conTipoCliente(TipoCliente.ESPECIAL)
                .reconstruir();

        Assertions.assertEquals(1l, cliente.getId());
        Assertions.assertEquals("Cliente 1", cliente.getNombre());
        Assertions.assertEquals("Av 6", cliente.getDireccion());
        Assertions.assertEquals("55555", cliente.getTelefono());
        Assertions.assertEquals("cliente@gmail.com", cliente.getEmail());
        Assertions.assertEquals(TipoCliente.ESPECIAL, cliente.getTipoCliente());
    }



    @Test
    void reconstruirSinIdDeberiaLanzarError() {
        BasePrueba.assertThrows(() -> new ClienteTestDataBuilder()
                        .conNombre("Cliente 1")
                        .conDireccion("Av 6")
                        .conTelefono("55555")
                        .conEmail("cliente@gmail.com")
                        .conTipoCliente (TipoCliente.COMUN)
                        .reconstruir(), ExcepcionValorObligatorio.class,
                "Id del cliente es requerido");
    }
    @Test
    void reconstruirSinNombreDeberiaLanzarError() {
        BasePrueba.assertThrows(() -> new ClienteTestDataBuilder()
                        .conId(1l)
                        .conDireccion("Av 6")
                        .conTelefono("55555")
                        .conEmail("cliente@gmail.com")
                        .conTipoCliente (TipoCliente.COMUN)
                        .reconstruir(), ExcepcionValorObligatorio.class,
                "Nombre del cliente es requerido");
    }
    @Test
    void reconstruirSinDireccionDeberiaLanzarError() {
        BasePrueba.assertThrows(() -> new ClienteTestDataBuilder()
                        .conId(1l)
                        .conNombre("Cliente 1")
                        .conTelefono("55555")
                        .conEmail("cliente@gmail.com")
                        .conTipoCliente (TipoCliente.COMUN)
                        .reconstruir(), ExcepcionValorObligatorio.class,
                "La direccion es requerido");
    }
    @Test
    void reconstruirSinTelefonoDeberiaLanzarError() {
        BasePrueba.assertThrows(() -> new ClienteTestDataBuilder()
                        .conId(1l)
                        .conNombre("Cliente 1")
                        .conDireccion("Av 6")
                        .conEmail("cliente@gmail.com")
                        .conTipoCliente (TipoCliente.COMUN)
                        .reconstruir(), ExcepcionValorObligatorio.class,
                "El telefono del cliente es requerido");
    }
    @Test
    void reconstruirSinEmailDeberiaLanzarError() {
        BasePrueba.assertThrows(() -> new ClienteTestDataBuilder()
                        .conId(1l)
                        .conNombre("Cliente 1")
                        .conDireccion("Av 6")
                        .conTelefono("55555")
                        .conTipoCliente (TipoCliente.COMUN)
                        .reconstruir(), ExcepcionValorObligatorio.class,
                "El Email  del cliente es requerido");
    }
    @Test
    void reconstruirSinTipoClienteDeberiaLanzarError() {
        BasePrueba.assertThrows(() -> new ClienteTestDataBuilder()
                        .conId(1l)
                        .conNombre("Cliente 1")
                        .conDireccion("Av 6")
                        .conTelefono("55555")
                        .conEmail("cliente@gmail.com")
                        .reconstruir(), ExcepcionValorObligatorio.class,
                "Tipo de cliente es requerido");
    }
}