package com.ceiba.alquiler.controlador;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
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
import com.ceiba.alquiler.comando.ComandoAlquiler;
import com.ceiba.alquiler.modelo.entidad.Alquiler;
import com.ceiba.alquiler.puerto.repositorio.RepositorioAlquiler;
import com.ceiba.alquiler.servicio.testdatabuilder.ComandoAlquilerTestDataBuilder;
import com.ceiba.auto.modelo.entidad.Auto;
import com.ceiba.auto.modelo.entidad.EstadoAuto;
import com.ceiba.auto.puerto.repositorio.RepositorioAuto;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ComandoControladorAlquiler.class)
public class ComandoControladorAlquilerTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;
    
    @Autowired
    private RepositorioAlquiler repositorioAlquiler;
    
    @Autowired
    private RepositorioAuto repositorioAuto;
    
    @Test
    public void crearAlquilerTest() throws Exception{
        // arrange
        ComandoAlquiler comanndoAlquiler = new ComandoAlquilerTestDataBuilder().build();

        // act - assert
        mocMvc.perform(post("/alquiler")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comanndoAlquiler)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 3}"));
        
        Alquiler alquiler = repositorioAlquiler.buscar(3L);
        Auto auto = repositorioAuto.buscar(comanndoAlquiler.getAutoId());
		assertEquals(3, alquiler.getId().longValue());
		assertEquals(comanndoAlquiler.getFechaAlquiler(), alquiler.getFechaAlquiler());
		assertEquals(comanndoAlquiler.getFechaDevolucion(), alquiler.getFechaDevolucion());
		assertEquals(comanndoAlquiler.getAutoId(), alquiler.getAuto().getId());
		assertEquals(comanndoAlquiler.getClienteId(), alquiler.getCliente().getId());
        assertEquals(EstadoAuto.ALQUILADO, auto.getEstado());
    }
}
