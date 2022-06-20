package com.ceiba.planta;

import com.ceiba.ApplicationMock;
import com.ceiba.planta.controlador.ComandoControladorPlanta;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ApplicationMock.class)
@WebMvcTest(ComandoControladorPlanta.class)
public class PlantaControladorTest {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

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

//    @Test
//    public void crear() throws Exception {
//        // arrange
//        ComandoPlanta tecnico = new PlantaTestDataBuilderComando().build();
//
//        // act - assert
//        mocMvc.perform(post("/apiPlanta/crear")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(tecnico)))
//                .andExpect(status().isOk())
//                .andExpect(content().json("{"valor": 1}"));
//    }

}
