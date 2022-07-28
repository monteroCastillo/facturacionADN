package com.ceiba.proveedor;

import com.ceiba.empleado.modelo.entidad.Empleado;
import com.ceiba.empleado.puerto.repositorio.RepositorioEmpleado;
import com.ceiba.empleado.servicio.ServicioCrearEmpleado;
import com.ceiba.proveedor.modelo.entidad.Proveedor;
import com.ceiba.proveedor.puerto.repositorio.RepositorioProveedor;
import com.ceiba.proveedor.servicio.ServicioCrearProveedor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

public class SolicitudCrearProveedorTest {

    @Test
    void deberiaGuardarProveedor(){
        Proveedor proveedor = new ProveedorTestDataBuilder()
                .conProveedorPorDefecto()
                .reconstruir();
        var solicitudCrearProveedor = new SolicitudProveedorTestDataBuilder()
                .conId(1l)
                .conNombre("Proveedor 1")
                .conDireccion("Av 4")
                .conTelefono("55555")
                .conPaginaWeb("proveedor.com.co")
                .construir();
        var repositorioProveedor = Mockito.mock(RepositorioProveedor.class);
        Mockito.when(repositorioProveedor.guardar(Mockito.any())).thenReturn(1L);

        var servicioCrearProveedor = new ServicioCrearProveedor(repositorioProveedor);
        var idProveedorGuardado = servicioCrearProveedor.ejecutar(solicitudCrearProveedor);

        ArgumentCaptor<Proveedor> captorProveedor = ArgumentCaptor.forClass(Proveedor.class);
        Mockito.verify(repositorioProveedor,  Mockito.times(1)).guardar(captorProveedor.capture());

        Assertions.assertEquals(1l, idProveedorGuardado);
        Assertions.assertEquals("Proveedor 1", captorProveedor.getValue().getNombre());
        Assertions.assertEquals("Av 4", captorProveedor.getValue().getDireccion());
        Assertions.assertEquals("55555", captorProveedor.getValue().getTelefono());
        Assertions.assertEquals("proveedor.com.co", captorProveedor.getValue().getPaginaWeb());
    }
}
