package com.ceiba.Proveedor.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.Proveedor.controlador.testDataBuilder.ComandoProveedorTestDataBuilder;
import com.ceiba.factura.controlador.ComandoControladorFactura;
import com.ceiba.proveedor.puerto.repositorio.RepositorioProveedor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ComandoControladorFactura.class)
@ContextConfiguration(classes = ApplicationMock.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ComandoControladorProveedorTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Autowired
    private RepositorioProveedor repositorioProveedor;

    @Test
    void crearProveedorExitoso() throws Exception{
        var comandoProveecorTestDataBuilder = new ComandoProveedorTestDataBuilder().build();


    }
}
