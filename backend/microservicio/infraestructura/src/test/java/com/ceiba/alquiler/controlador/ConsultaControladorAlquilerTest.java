package com.ceiba.alquiler.controlador;

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
@WebMvcTest(ConsultaControladorAlquiler.class)
public class ConsultaControladorAlquilerTest {

    @Autowired
    private MockMvc mocMvc;

    @Test
    public void listarAlquilerTest() throws Exception{
        // arrange
    	// act - assert
        mocMvc.perform(get("/alquiler")
                .contentType(MediaType.APPLICATION_JSON))
        		.andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].auto.id", is(1)))
                .andExpect(jsonPath("$[0].cliente.id", is(1)))
                .andExpect(jsonPath("$[0].subTotal", is(2280000.00)))
                .andExpect(jsonPath("$[0].descuento", is(182400.00)))
                .andExpect(jsonPath("$[0].total", is(2097600.00)))
                .andExpect(jsonPath("$[0].fechaAlquiler", is("2021-01-01")))
                .andExpect(jsonPath("$[0].fechaDevolucion", is("2021-01-20")))
                .andExpect(jsonPath("$[0].fechaCreacion", is("2021-01-01 08:21:16")))
                
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].auto.id", is(2)))
                .andExpect(jsonPath("$[1].cliente.id", is(2)))
                .andExpect(jsonPath("$[1].subTotal", is(2280000.00)))
                .andExpect(jsonPath("$[1].descuento", is(182400.00)))
                .andExpect(jsonPath("$[1].total", is(2097600.00)))
                .andExpect(jsonPath("$[1].fechaAlquiler", is("2021-01-05")))
                .andExpect(jsonPath("$[1].fechaDevolucion", is("2021-01-25")))
                .andExpect(jsonPath("$[1].fechaCreacion", is("2021-01-05 07:00:00")))
        		;
    }
}
