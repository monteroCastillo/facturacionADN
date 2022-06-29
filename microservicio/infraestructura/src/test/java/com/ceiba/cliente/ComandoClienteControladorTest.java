package com.ceiba.cliente;

import com.ceiba.ApplicationMock;
import com.ceiba.RespuestaComando;
import com.ceiba.cliente.adaptador.repositorio.RepositorioClienteMysql;
import com.ceiba.cliente.controlador.ComandoControladorCliente;
import com.ceiba.cliente.puerto.dao.DaoCliente;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ComandoControladorCliente.class)
@ContextConfiguration(classes = ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ComandoClienteControladorTest {
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private MockMvc mocMvc;
    @Autowired
    private DaoCliente daoCliente;

    @Autowired
    private RepositorioClienteMysql repositorioClienteMysql;

    @Test
    void crearClienteExitoso() throws Exception{
        var comandoClienteTestDataBuilder = new ComandoClienteTestDataBuilder().build();

        var resultado = mocMvc.perform(post("/apiCliente/crear")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(comandoClienteTestDataBuilder)))
                .andExpect(status().is2xxSuccessful()).andReturn();

        String jsonResult = resultado.getResponse().getContentAsString();
        var respuesta = objectMapper.readValue(jsonResult, RespuestaComando.class);
        var clienteGuardado = daoCliente.obtenerClientePorId(respuesta.getValor());



        Assertions.assertEquals(1L, clienteGuardado.getId());
        Assertions.assertEquals("cliente", clienteGuardado.getNombre());
        Assertions.assertEquals("Av 6", clienteGuardado.getDireccion());
        Assertions.assertEquals("55555", clienteGuardado.getTelefono());
        Assertions.assertEquals("cliente@gmail.com", clienteGuardado.getEmail());
        Assertions.assertEquals("COMUN", clienteGuardado.getTipoCliente().name());

    }

    @Test
    public void eliminar() throws Exception {
        // arrange
        Long id = 1l;
        // act - assert
        mocMvc.perform(delete("/apiPlanta/borrar/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


}
