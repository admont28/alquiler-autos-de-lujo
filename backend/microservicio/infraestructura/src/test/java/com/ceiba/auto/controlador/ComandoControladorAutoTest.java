package com.ceiba.auto.controlador;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.InputStream;
import java.net.URI;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.ceiba.ApplicationMock;
import com.ceiba.auto.comando.ComandoAuto;
import com.ceiba.auto.modelo.entidad.Auto;
import com.ceiba.auto.modelo.entidad.EstadoAuto;
import com.ceiba.auto.puerto.almacenamiento.AlmacenamientoAuto;
import com.ceiba.auto.puerto.repositorio.RepositorioAuto;
import com.ceiba.auto.servicio.testdatabuilder.ComandoAutoTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ComandoControladorAuto.class)
public class ComandoControladorAutoTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;
    
    @Autowired
    private RepositorioAuto repositorioAuto;

    @Test
    public void crear() throws Exception{
        // arrange
        ComandoAuto comandoAuto = new ComandoAutoTestDataBuilder().build();
        
        AlmacenamientoAuto almacenamientoAuto = Mockito.mock(AlmacenamientoAuto.class);
        Mockito.when(almacenamientoAuto.cargarImagen(Mockito.any(InputStream.class))).thenReturn(new URI(""));

        // act - assert
        mocMvc.perform(post("/autos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoAuto)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 4}"));
        
        Long id = 4L;
		Auto auto = repositorioAuto.buscar(id);
        assertEquals(id, auto.getId());
        assertEquals(comandoAuto.getSerial(), auto.getSerial());
        assertEquals(comandoAuto.getNombre(), auto.getNombre());
        assertEquals(comandoAuto.getModelo(), auto.getModelo());
        assertEquals(comandoAuto.getPrecioPorDia(), auto.getPrecioPorDia());
        assertEquals(EstadoAuto.DISPONIBLE, auto.getEstado());
    }
    
    @Test
    public void actualizar() throws Exception{
        // arrange
        Long id = 2L;
        ComandoAuto comandoAuto = new ComandoAutoTestDataBuilder().conSerial("nuevo-serial-1234").conNombre("Bugatti Veyron").build();

        // act - assert
        mocMvc.perform(put("/autos/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoAuto)))
                .andExpect(status().isOk());
        
        Auto auto = repositorioAuto.buscar(id);
        assertEquals(id, auto.getId());
        assertEquals(comandoAuto.getSerial(), auto.getSerial());
        assertEquals(comandoAuto.getNombre(), auto.getNombre());
        assertEquals(comandoAuto.getModelo(), auto.getModelo());
        assertEquals(comandoAuto.getPrecioPorDia(), auto.getPrecioPorDia());
        assertEquals(EstadoAuto.DISPONIBLE, auto.getEstado());
    }
    
    @Test
    public void actualizarConEstadoNulo() throws Exception{
    	// arrange
    	Long id = 2L;
    	ComandoAuto comandoAuto = new ComandoAutoTestDataBuilder().conEstado(null).build();
    	
    	// act - assert
    	mocMvc.perform(put("/autos/{id}",id)
    			.contentType(MediaType.APPLICATION_JSON)
    			.content(objectMapper.writeValueAsString(comandoAuto)))
    	.andExpect(status().isOk());
    	
    	Auto auto = repositorioAuto.buscar(id);
    	assertEquals(id, auto.getId());
    	assertEquals(comandoAuto.getSerial(), auto.getSerial());
    	assertEquals(comandoAuto.getNombre(), auto.getNombre());
    	assertEquals(comandoAuto.getModelo(), auto.getModelo());
    	assertEquals(comandoAuto.getPrecioPorDia(), auto.getPrecioPorDia());
    	assertEquals(EstadoAuto.DISPONIBLE, auto.getEstado());
    }
}
