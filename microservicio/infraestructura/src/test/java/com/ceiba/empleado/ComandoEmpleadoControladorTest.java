package com.ceiba.empleado;

import com.ceiba.ApplicationMock;
import com.ceiba.RespuestaComando;
import com.ceiba.empleado.puerto.dao.DaoEmpleado;
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

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ComandoControladorEmpleado.class)
@ContextConfiguration(classes = ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ComandoEmpleadoControladorTest {

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mocMvc;
    @Autowired
    private DaoEmpleado daoEmpleado;

    @Test
    void crearEmpleadoExitoso() throws Exception{
        var comandoEmpleadoTestDataBuilder = new ComandoEmpleadoTestDataBuilder().build();


        var resultado = mocMvc.perform(post("/apiEmpleado/guardar")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(comandoEmpleadoTestDataBuilder)))
                .andExpect(status().is2xxSuccessful()).andReturn();

        String jsonResult = resultado.getResponse().getContentAsString();
        var respuesta = objectMapper.readValue(jsonResult, RespuestaComando.class);

        var empleadoGuardado = daoEmpleado.obtenerEmpleadoPorId(respuesta.getValor());

        LocalDate hoy = LocalDate.now();
        Assertions.assertEquals(1L, empleadoGuardado.getIdEmpleado());
        Assertions.assertEquals("Laura", empleadoGuardado.getNombre());
        Assertions.assertEquals("Av 6", empleadoGuardado.getDireccion());
        Assertions.assertEquals("5555", empleadoGuardado.getTelefono());
        Assertions.assertEquals("Laura@hotmail.com", empleadoGuardado.getEmail());
        Assertions.assertEquals(hoy, empleadoGuardado.getFechaRegistro());
        Assertions.assertEquals("ADMINISTRADOR", empleadoGuardado.getPerfil().name());

    }
}
