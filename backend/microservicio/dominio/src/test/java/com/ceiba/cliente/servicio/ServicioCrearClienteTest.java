package com.ceiba.cliente.servicio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.modelo.entidad.EstadoCliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.cliente.servicio.testdatabuilder.ClienteTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;

public class ServicioCrearClienteTest {
	
	@Test
	public void validarNombreClienteTest() {
		// arrange
        ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder().conNombre(null);
        
        // act - assert
        BasePrueba.assertThrows(() -> clienteTestDataBuilder.build(), ExcepcionValorObligatorio.class, "Se debe ingresar el nombre del cliente");
	}
	
	@Test
	public void validarApellidoClienteTest() {
		// arrange
        ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder().conApellido(null);
        
        // act - assert
        BasePrueba.assertThrows(() -> clienteTestDataBuilder.build(), ExcepcionValorObligatorio.class, "Se debe ingresar el apellido del cliente");
	}
	
	@Test
	public void validarDireccionClienteTest() {
		// arrange
        ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder().conDireccion(null);
        
        // act - assert
        BasePrueba.assertThrows(() -> clienteTestDataBuilder.build(), ExcepcionValorObligatorio.class, "Se debe ingresar la dirección del cliente");
	}
	
	@Test
	public void validarCedulaClienteTest() {
		// arrange
        ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder().conCedula(null);
        
        // act - assert
        BasePrueba.assertThrows(() -> clienteTestDataBuilder.build(), ExcepcionValorObligatorio.class, "Se debe ingresar la cédula del cliente");
	}
	
	@Test
	public void validarCambioEstadoClienteEliminadoTest() {
		// arrange
        Cliente cliente = new ClienteTestDataBuilder().build();
        
        // act 
        cliente.cambiarEstadoAEliminado();
        
        // assert
        assertEquals(EstadoCliente.ELIMINADO, cliente.getEstado());
	}

    @Test
    public void validarClienteExistenciaPreviaTest() {
        // arrange
    	Cliente cliente = new ClienteTestDataBuilder().build();
        RepositorioCliente repositorioCliente = Mockito.mock(RepositorioCliente.class);
        Mockito.when(repositorioCliente.existe(Mockito.anyString())).thenReturn(true);
        ServicioCrearCliente servicioCrearCliente = new ServicioCrearCliente(repositorioCliente);
        
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearCliente.ejecutar(cliente), ExcepcionDuplicidad.class, "El cliente ya existe en el sistema");
    }
    
    @Test
    public void crearClienteTest() {
        // arrange
    	Cliente cliente = new ClienteTestDataBuilder().build();
        RepositorioCliente repositorioCliente = Mockito.mock(RepositorioCliente.class);
        Mockito.when(repositorioCliente.existe(Mockito.anyString())).thenReturn(false);
        Mockito.when(repositorioCliente.crear(Mockito.anyObject())).thenReturn(1L);
        ServicioCrearCliente servicioCrearCliente = new ServicioCrearCliente(repositorioCliente);
        
        // act 
        Long clienteId = servicioCrearCliente.ejecutar(cliente);
        
        // assert
        assertEquals(cliente.getId(), clienteId);
    }
    
    
}
