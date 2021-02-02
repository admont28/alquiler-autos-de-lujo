package com.ceiba.cliente.servicio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.modelo.entidad.EstadoCliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.cliente.servicio.testdatabuilder.ClienteTestDataBuilder;

public class ServicioEliminarClienteTest {
    
    @Test
    public void actualizarAutoTest() {
        // arrange
    	Cliente cliente = new ClienteTestDataBuilder().build();
        RepositorioCliente repositorioCliente = Mockito.mock(RepositorioCliente.class);
        ServicioEliminarCliente servicioEliminarCliente = new ServicioEliminarCliente(repositorioCliente);
        
        // act 
        servicioEliminarCliente.ejecutar(cliente);
        
        // assert
        Mockito.verify(repositorioCliente, times(1)).actualizar(cliente);
        assertEquals(EstadoCliente.ELIMINADO, cliente.getEstado());
    }
    
    
}
