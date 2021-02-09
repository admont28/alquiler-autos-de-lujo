package com.ceiba.cliente.controlador;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
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
import com.ceiba.cliente.comando.ComandoCliente;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.modelo.entidad.EstadoCliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.cliente.servicio.testdatabuilder.ComandoClienteTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ComandoControladorCliente.class)
public class ComandoControladorClienteTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;
    
    @Autowired
    private RepositorioCliente repositorioCliente;
    
    @Test
    public void crear() throws Exception{
        // arrange
        ComandoCliente comandoCliente = new ComandoClienteTestDataBuilder().build();

        // act - assert
        mocMvc.perform(post("/clientes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoCliente)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 4}"));
        
        Long id = 4L;
        Cliente cliente = repositorioCliente.buscar(id);
        assertEquals(id, cliente.getId());
        assertEquals(comandoCliente.getNombre(), cliente.getNombre());
        assertEquals(comandoCliente.getApellido(), cliente.getApellido());
        assertEquals(comandoCliente.getDireccion(), cliente.getDireccion());
        assertEquals(comandoCliente.getCedula(), cliente.getCedula());
        assertEquals(EstadoCliente.ACTIVO, cliente.getEstado());
    }

    @Test
    public void actualizar() throws Exception{
        // arrange
        Long id = 2L;
        ComandoCliente comandoCliente = new ComandoClienteTestDataBuilder().conCedula("1094951666").conNombre("Nombre actualizado").conApellido("Apellido actualizado").build();

        // act - assert
        mocMvc.perform(put("/clientes/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoCliente)))
                .andExpect(status().isOk());
        
        Cliente cliente = repositorioCliente.buscar(id);
        assertEquals(id, cliente.getId());
        assertEquals(comandoCliente.getNombre(), cliente.getNombre());
        assertEquals(comandoCliente.getApellido(), cliente.getApellido());
        assertEquals(comandoCliente.getDireccion(), cliente.getDireccion());
        assertEquals(comandoCliente.getCedula(), cliente.getCedula());
        assertEquals(EstadoCliente.ACTIVO, cliente.getEstado());
    }
    
    @Test
    public void actualizarConEstadoNulo() throws Exception{
    	// arrange
        Long id = 2L;
        ComandoCliente comandoCliente = new ComandoClienteTestDataBuilder().conEstado(null).build();

        // act - assert
        mocMvc.perform(put("/clientes/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoCliente)))
                .andExpect(status().isOk());
        
        Cliente cliente = repositorioCliente.buscar(id);
        assertEquals(id, cliente.getId());
        assertEquals(comandoCliente.getNombre(), cliente.getNombre());
        assertEquals(comandoCliente.getApellido(), cliente.getApellido());
        assertEquals(comandoCliente.getDireccion(), cliente.getDireccion());
        assertEquals(comandoCliente.getCedula(), cliente.getCedula());
        assertEquals(EstadoCliente.ACTIVO, cliente.getEstado());
    }
    
    @Test
    public void eliminar() throws Exception{
        // arrange
        Long id = 2L;

        // act - assert
        mocMvc.perform(delete("/clientes/{id}", id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString("")))
                .andExpect(status().isOk());
        
        Cliente cliente = repositorioCliente.buscar(id);
        assertEquals(id, cliente.getId());
        assertEquals(EstadoCliente.ELIMINADO, cliente.getEstado());
    }
}
