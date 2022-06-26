package com.ceiba.planta;

import com.ceiba.ApplicationMock;
import com.ceiba.RespuestaComando;
import com.ceiba.factura.controlador.ComandoFacturarTestDataBuilder;
import com.ceiba.factura.controlador.RespuestaFacturar;
import com.ceiba.planta.comando.ComandoPlanta;
import com.ceiba.planta.controlador.ComandoControladorPlanta;
import com.ceiba.planta.puerto.dao.DaoPlanta;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ComandoControladorPlanta.class)
public class ComandoPlantaControladorTest {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mocMvc;
    @Autowired
    private DaoPlanta daoPlanta;

    @Test
    void crear() throws Exception {
        var comando = new ComandoPlantaTestDataBuilder().crearPorDefecto().build();

        var resultado = mocMvc.perform(post("/apiPlanta/crear")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(comando)))
                .andExpect(status().is2xxSuccessful()).andReturn();

        String jsonResult = resultado.getResponse().getContentAsString();
        var respuesta = objectMapper.readValue(jsonResult, RespuestaComando.class);
        System.out.println("****** respuesta ******" + respuesta.getValor().intValue());

        var plantaGuardada = daoPlanta.obtener(respuesta.getValor().intValue());

        Assertions.assertEquals("manzanilla", plantaGuardada.getNombre());
//        Assertions.assertEquals(235000l, facturaGuardada.getValorTotal().longValue());
//        Assertions.assertEquals(2, facturaGuardada.getProductos().size());

    }

    @Test
    public void eliminar() throws Exception {
        // arrange
        int id = 1;
        // act - assert
        mocMvc.perform(delete("/apiPlanta/borrar/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


}
