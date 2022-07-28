package com.ceiba.proveedor;


import com.ceiba.proveedor.modelo.entidad.Proveedor;



import com.ceiba.proveedor.puerto.repositorio.RepositorioProveedor;
import com.ceiba.proveedor.servicio.ServicioActualizarProveedor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.times;


public class ServicioActualizarProveedorTest {


    @Autowired
    private MockMvc mocMvc;



//    @Test
//    public void validarProveedorExistenciaPreviaTest() {
//        // arrange
//        Proveedor proveedor = new ProveedorTestDataBuilder().conProveedorPorDefecto().reconstruir();
//        RepositorioProveedor repositorioProveedor = Mockito.mock(RepositorioProveedor.class);
//        Mockito.when(repositorioProveedor.existe(Mockito.anyLong())).thenReturn(false);
//        ServicioActualizarProveedor servicioActualizarProveedor = new ServicioActualizarProveedor(repositorioProveedor);
//        // act - assert
//        BasePrueba.assertThrows(() -> repositorioProveedor.actualizar(proveedor), ExcepcionSinDatos.class, MensajesDeExcepcion.NO_EXISTE_UNA_PERSONA_REGISTRADO_CON_ESTE_ID.getMensaje());
//    }

    @Test
    public void validarActualizacionProveedorTest() {
        // arrange
        Proveedor proveedor = new ProveedorTestDataBuilder().conProveedorPorDefecto().reconstruir();
        var repositorioProveedor = Mockito.mock(RepositorioProveedor.class);

        Mockito.when(repositorioProveedor.guardar(Mockito.any())).thenReturn(1l);
        ServicioActualizarProveedor servicioActualizarProveedor = new ServicioActualizarProveedor(repositorioProveedor);
        // act - assert
        repositorioProveedor.actualizar(proveedor);
        Mockito.verify(repositorioProveedor,times(1)).actualizar(proveedor);
    }


}
