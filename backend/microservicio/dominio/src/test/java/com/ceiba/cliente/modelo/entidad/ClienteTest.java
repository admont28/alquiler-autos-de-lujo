package com.ceiba.cliente.modelo.entidad;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import com.ceiba.BasePrueba;
import com.ceiba.cliente.servicio.testdatabuilder.ClienteTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;

public class ClienteTest {

	@Test
	public void validarNombreClienteTest() {
		// arrange
        ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder().conNombre(null);
        
        // act - assert
        BasePrueba.assertThrows(() -> clienteTestDataBuilder.build(), ExcepcionValorObligatorio.class, "Se debe ingresar el nombre del cliente");
	}
	
	@Test
	public void validarLongitudNombreClienteTest() {
		// arrange
        ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder().conNombre("an");
        
        // act - assert
        BasePrueba.assertThrows(() -> clienteTestDataBuilder.build(), ExcepcionLongitudValor.class, "El nombre del cliente debe tener mínimo 3 caracteres");
	}
	
	@Test
	public void validarApellidoClienteTest() {
		// arrange
        ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder().conApellido(null);
        
        // act - assert
        BasePrueba.assertThrows(() -> clienteTestDataBuilder.build(), ExcepcionValorObligatorio.class, "Se debe ingresar el apellido del cliente");
	}
	
	@Test
	public void validarLongitudApellidoClienteTest() {
		// arrange
        ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder().conApellido("mo");
        
        // act - assert
        BasePrueba.assertThrows(() -> clienteTestDataBuilder.build(), ExcepcionLongitudValor.class, "El apellido del cliente debe tener mínimo 3 caracteres");
	}
	
	@Test
	public void validarDireccionClienteTest() {
		// arrange
        ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder().conDireccion(null);
        
        // act - assert
        BasePrueba.assertThrows(() -> clienteTestDataBuilder.build(), ExcepcionValorObligatorio.class, "Se debe ingresar la dirección del cliente");
	}
	
	@Test
	public void validarLongitudDireccionClienteTest() {
		// arrange
        ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder().conDireccion("ca");
        
        // act - assert
        BasePrueba.assertThrows(() -> clienteTestDataBuilder.build(), ExcepcionLongitudValor.class, "La dirección del cliente debe tener mínimo 3 caracteres");
	}
	
	@Test
	public void validarCedulaClienteTest() {
		// arrange
        ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder().conCedula(null);
        
        // act - assert
        BasePrueba.assertThrows(() -> clienteTestDataBuilder.build(), ExcepcionValorObligatorio.class, "Se debe ingresar la cédula del cliente");
	}
	
	@Test
	public void validarLongitudCedulaClienteTest() {
		// arrange
        ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder().conCedula("10");
        
        // act - assert
        BasePrueba.assertThrows(() -> clienteTestDataBuilder.build(), ExcepcionLongitudValor.class, "La cédula del cliente debe tener mínimo 3 caracteres");
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

}
