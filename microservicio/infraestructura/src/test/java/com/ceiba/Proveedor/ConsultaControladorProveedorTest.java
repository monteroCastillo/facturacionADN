package com.ceiba.Proveedor;

import com.ceiba.ApplicationMock;
import com.ceiba.proveedor.controlador.ConsultaControladorProveedor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ConsultaControladorProveedor.class)
@ContextConfiguration(classes = ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ConsultaControladorProveedorTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void consultarProveedores() throws Exception{
        mockMvc.perform(get("/proveedores/index")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$[0].nombre", is("plantas y plantas")))
                .andExpect(jsonPath("$[0].direccion", is("Av vasquez Cobo")))
                .andExpect(jsonPath("$[0].telefono", is("5656565")));
    }

    @Test
    void consultarUnProveedor() throws Exception{

        Long id = 1L;
        mockMvc.perform(get("/proveedores/buscar/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());
    }


}
