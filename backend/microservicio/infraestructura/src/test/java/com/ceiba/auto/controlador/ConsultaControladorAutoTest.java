package com.ceiba.auto.controlador;

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
@WebMvcTest(ConsultaControladorAuto.class)
public class ConsultaControladorAutoTest {

    @Autowired
    private MockMvc mocMvc;

    @Test
    public void listarAutosTest() throws Exception{
        // arrange
    	// act - assert
        mocMvc.perform(get("/autos")
                .contentType(MediaType.APPLICATION_JSON))
        		.andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].serial", is("serial-4321")))
                .andExpect(jsonPath("$[0].nombre", is("BMW I3")))
                .andExpect(jsonPath("$[0].modelo", is("2021")))
                .andExpect(jsonPath("$[0].precioPorDia", is(120000.00)))
                .andExpect(jsonPath("$[0].estado", is("DISPONIBLE")))
                .andExpect(jsonPath("$[0].fechaCreacion", is("2021-01-30 23:15:00")))
        		;
    }
}
