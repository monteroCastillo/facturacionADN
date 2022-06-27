package com.ceiba.factura.controlador;

import com.ceiba.ApplicationMock;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


import java.time.LocalDate;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ConsultaControladorFactura.class)
@ContextConfiguration(classes = ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ConsultaControladorFacturaTest {

    @Autowired
    private MockMvc mocMvc;

    @Test
    void consultarFacturasAnuladas() throws Exception {

        mocMvc.perform(get("/factura/anulada")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful())

                .andExpect(jsonPath("$[0].id", is(55)))
                .andExpect(jsonPath("$[0].valorTotal", is(300.0)))
                .andExpect(jsonPath("$[0].estado", is("ANULADA")));

    }

    @Test
    void consultarSumaFacturas() throws Exception {
        LocalDate fecha = LocalDate.of(2022,6,17);

        mocMvc.perform(get("/factura/sumarFacturas/{fecha}",fecha)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());

    }
}
