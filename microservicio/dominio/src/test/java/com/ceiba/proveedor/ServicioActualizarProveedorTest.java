package com.ceiba.proveedor;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.proveedor.modelo.entidad.Proveedor;
import com.ceiba.proveedor.puerto.repositorio.RepositorioProveedor;
import com.ceiba.proveedor.servicio.ServicioActualizarProveedor;
import com.ceiba.proveedor.utils.MensajesDeExcepcion;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ServicioActualizarProveedorTest {

    @Test
    public void validarProveedorExistenciaPreviaTest() {
        // arrange
        Proveedor proveedor = new ProveedorTestDataBuilder().conProveedorPorDefecto().build();
        RepositorioProveedor repositorioProveedor = Mockito.mock(RepositorioProveedor.class);
        Mockito.when(repositorioProveedor.existe(Mockito.anyLong())).thenReturn(false);
        ServicioActualizarProveedor servicioActualizarProveedor = new ServicioActualizarProveedor(repositorioProveedor);
        // act - assert
        //BasePrueba.assertThrows(() -> servicioActualizarProveedor.ejecutar(proveedor), ExcepcionSinDatos.class, MensajesDeExcepcion.NO_EXISTE_UNA_PERSONA_REGISTRADO_CON_ESTE_ID.getMensaje());
    }

    @Test
    public void validarActualizacionProveedorTest() {
        // arrange
        Proveedor proveedor = new ProveedorTestDataBuilder().conProveedorPorDefecto().build();
        RepositorioProveedor repositorioProveedor = Mockito.mock(RepositorioProveedor.class);
        Mockito.when(repositorioProveedor.existe(Mockito.anyLong())).thenReturn(true);
        ServicioActualizarProveedor servicioActualizarProveedor = new ServicioActualizarProveedor(repositorioProveedor);
        // act - assert
        servicioActualizarProveedor.ejecutar(proveedor);
        verify(repositorioProveedor,times(1)).actualizar(proveedor);
    }
}
