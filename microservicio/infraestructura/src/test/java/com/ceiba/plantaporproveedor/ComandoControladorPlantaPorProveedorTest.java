package com.ceiba.plantaporproveedor;

import com.ceiba.ApplicationMock;
import com.ceiba.RespuestaComando;
import com.ceiba.plantaporproveedor.controlador.ComandoControladorPlantaPorProveedor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ComandoControladorPlantaPorProveedor.class)
@ContextConfiguration(classes = ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ComandoControladorPlantaPorProveedorTest {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    void crearPlantaPorProveedorExitosa() throws Exception {
        var comando = new ComandoPlantaPorProveedorTestDataBuilder().crearPorDefecto().build();
        var resultado = mocMvc.perform(post("/apiPlantaPorProveedor/crear")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(comando)))
               .andExpect(status().is2xxSuccessful()).andReturn();

        String jsonResult = resultado.getResponse().getContentAsString();
        var respuesta = objectMapper.readValue(jsonResult, RespuestaComando.class);
    }

    @Test
    public void eliminar() throws Exception {
        // arrange
        Long id = 1l;
        // act - assert
        mocMvc.perform(delete("/apiPlantaPorProveedor/eliminar/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void existe() throws Exception {
        // arrange
        int id = 1;
        // act - assert
        mocMvc.perform(delete("/apiPlanta/borrar/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

}
