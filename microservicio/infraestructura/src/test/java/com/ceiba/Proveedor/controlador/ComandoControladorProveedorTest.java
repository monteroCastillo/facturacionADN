package com.ceiba.Proveedor.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.Proveedor.controlador.testDataBuilder.ComandoProveedorTestDataBuilder;
import com.ceiba.proveedor.controlador.ComandoControladorProveedor;
import com.ceiba.proveedor.puerto.dao.DaoProveedor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ComandoControladorProveedor.class)
@ContextConfiguration(classes = ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ComandoControladorProveedorTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Autowired
    private DaoProveedor daoProveedor;

    @Test
    void crearProveedorExitoso() throws Exception{
        var comandoProveedorTestDataBuilder = new ComandoProveedorTestDataBuilder().build();


        var resultado = mocMvc.perform(post("/apiProveedor/guardar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(comandoProveedorTestDataBuilder)))
                .andExpect(status().is2xxSuccessful()).andReturn();

        String jsonResult = resultado.getResponse().getContentAsString();
        var respuesta = objectMapper.readValue(jsonResult, RespuestaProveedor.class);

        var proveedorGuardado = daoProveedor.obtenerProveedorPorId(respuesta.getValor());

        Assertions.assertEquals(22, proveedorGuardado.getId());
        Assertions.assertEquals("plantas y plantas", proveedorGuardado.getNombre());
        Assertions.assertEquals("Av vasquez Cobo", proveedorGuardado.getDireccion());
        Assertions.assertEquals("5656565", proveedorGuardado.getTelefono());
        Assertions.assertEquals("plantasyplantas.com.co", proveedorGuardado.getPaginaWeb());


    }


//    @Test
//    public void eliminar() throws Exception {
//        // arrange
//        Long id = 1L;
//
//        // act - assert
//        mocMvc.perform(eliminar("/apiProveedor/{id}", id)
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk());
//    }


}
