package com.ceiba.cliente.controlador;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.ceiba.ApplicationMock;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ConsultaControladorCliente.class)
public class ConsultaControladorClienteTest {

    @Autowired
    private MockMvc mocMvc;

    @Test
    public void listarClientesTest() throws Exception{
        // arrange
    	// act - assert
        mocMvc.perform(get("/clientes")
                .contentType(MediaType.APPLICATION_JSON))
        		.andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].nombre", is("Andres David")))
                .andExpect(jsonPath("$[0].apellido", is("Montoya Aguirre")))
                .andExpect(jsonPath("$[0].direccion", is("Calle 39 #5-72")))
                .andExpect(jsonPath("$[0].cedula", is("1094937274")))
                .andExpect(jsonPath("$[0].estado", is("ACTIVO")))
                .andExpect(jsonPath("$[0].fechaCreacion", is("2021-02-01 15:20:53")))
        		;
    }
}
