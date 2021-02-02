package com.ceiba.cliente.servicio;

import static org.mockito.Mockito.times;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.cliente.servicio.testdatabuilder.ClienteTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioActualizarClienteTest {
	

    @Test
    public void validarClienteExistenciaPreviaTest() {
        // arrange
        Cliente cliente = new ClienteTestDataBuilder().build();
        RepositorioCliente repositorioCliente = Mockito.mock(RepositorioCliente.class);
        Mockito.when(repositorioCliente.existeExcluyendoId(Mockito.anyLong(), Mockito.anyString())).thenReturn(true);
        ServicioActualizarCliente servicioActualizarCliente = new ServicioActualizarCliente(repositorioCliente);
        
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarCliente.ejecutar(cliente), ExcepcionDuplicidad.class, "El cliente ya existe en el sistema");
    }
    
    @Test
    public void actualizarClienteTest() {
        // arrange
    	Cliente cliente = new ClienteTestDataBuilder().build();
        RepositorioCliente repositorioCliente = Mockito.mock(RepositorioCliente.class);
        Mockito.when(repositorioCliente.existeExcluyendoId(Mockito.anyLong(), Mockito.anyString())).thenReturn(false);
        ServicioActualizarCliente servicioActualizarCliente = new ServicioActualizarCliente(repositorioCliente);
        
        // act 
        servicioActualizarCliente.ejecutar(cliente);
        
        // assert
        Mockito.verify(repositorioCliente, times(1)).actualizar(cliente);
    }
    
    
}
