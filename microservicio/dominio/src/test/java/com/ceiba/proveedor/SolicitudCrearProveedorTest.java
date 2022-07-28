package com.ceiba.proveedor;

import com.ceiba.proveedor.modelo.entidad.Proveedor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SolicitudCrearProveedorTest {

    @Test
    void deberiaGuardarProveedor(){
        Proveedor proveedor = new ProveedorTestDataBuilder()
                .conProveedorPorDefecto()
                .reconstruir();
        var solicitudProveedor = new SolicitudProveedorTestDataBuilder()
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
}
