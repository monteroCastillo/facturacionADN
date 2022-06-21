package com.ceiba.proveedor;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProveedorTest {

    @Test
    void deberiaReconstruirProveedorExitosamente() {

        var proveedor = new ProveedorTestDataBuilder()
                .conId(1l)
                .conNombre("Proveedor 1")
                .conDireccion("Av 4")
                .conTelefono("55555")
                .conPaginaWeb("proveedor.com.co")
                .reconstruir();

        Assertions.assertEquals(1l, proveedor.getId());
        Assertions.assertEquals("Proveedor 1", proveedor.getNombre());
        Assertions.assertEquals("Av 4", proveedor.getDireccion());
        Assertions.assertEquals("55555", proveedor.getTelefono());
        Assertions.assertEquals("proveedor.com.co", proveedor.getPaginaWeb());
    }

    @Test
    void reconstruirSinIddeberiaDeberiaLanzarError() {
        BasePrueba.assertThrows(() -> new ProveedorTestDataBuilder()
                        .conNombre("Proveedor 1")
                        .conDireccion("Av 4")
                        .conTelefono("55555")
                        .conPaginaWeb("proveedor.com.co")
                        .reconstruir(), ExcepcionValorObligatorio.class,
                "El id del proveedor es requerido");
    }
    @Test
    void reconstruirSinNombredeberiaDeberiaLanzarError() {
        BasePrueba.assertThrows(() -> new ProveedorTestDataBuilder()
                        .conId(1l)
                        .conDireccion("Av 4")
                        .conTelefono("55555")
                        .conPaginaWeb("proveedor.com.co")
                        .reconstruir(), ExcepcionValorObligatorio.class,
                "el nombre del proveedor es requerido");
    }
    @Test
    void reconstruirSinDirecciondeberiaDeberiaLanzarError() {
        BasePrueba.assertThrows(() -> new ProveedorTestDataBuilder()
                        .conId(1l)
                        .conNombre("Proveedor 1")
                        .conTelefono("55555")
                        .conPaginaWeb("proveedor.com.co")
                        .reconstruir(), ExcepcionValorObligatorio.class,
                "La direccion del proveedor es requerida");
    }
    @Test
    void reconstruirSinPaginaWebdeberiaDeberiaLanzarError() {
        BasePrueba.assertThrows(() -> new ProveedorTestDataBuilder()
                        .conId(1l)
                        .conNombre("Proveedor 1")
                        .conTelefono("55555")
                        .conDireccion("Av 4")
                        .reconstruir(), ExcepcionValorObligatorio.class,
                "La pagina web del proveedor es requerida");
    }
    @Test
    void reconstruirSinTelefonodeberiaDeberiaLanzarError() {
        BasePrueba.assertThrows(() -> new ProveedorTestDataBuilder()
                        .conId(1l)
                        .conNombre("Proveedor 1")
                        .conPaginaWeb("proveedor.com.co")
                        .conDireccion("Av 4")
                        .reconstruir(), ExcepcionValorObligatorio.class,
                "El telefono del proveedor es requerido");
    }

}