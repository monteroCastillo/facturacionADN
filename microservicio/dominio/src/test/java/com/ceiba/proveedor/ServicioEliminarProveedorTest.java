package com.ceiba.proveedor;

import com.ceiba.proveedor.modelo.entidad.Proveedor;
import com.ceiba.proveedor.puerto.repositorio.RepositorioProveedor;
import com.ceiba.proveedor.servicio.ServicioEliminarProveedor;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioEliminarProveedorTest {
    @Test
    void deberiaEliminarProveedor(){
        Proveedor proveedor = new ProveedorTestDataBuilder()
                .conId(1L)
                .conProveedorPorDefecto()
                .reconstruir();

        var repositorioProveedor = Mockito.mock(RepositorioProveedor.class);
        Mockito.when(repositorioProveedor.guardar(Mockito.any())).thenReturn(1L);

        var servicioProveedor = new ServicioEliminarProveedor(repositorioProveedor);
        servicioProveedor.ejecutar(proveedor.getId());

        Mockito.verify(repositorioProveedor,Mockito.times(1)).eliminar(proveedor.getId());
    }
}
