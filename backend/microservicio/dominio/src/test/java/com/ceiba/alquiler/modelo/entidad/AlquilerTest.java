package com.ceiba.alquiler.modelo.entidad;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.Test;

import com.ceiba.BasePrueba;
import com.ceiba.alquiler.servicio.testdatabuilder.AlquilerTestDataBuilder;
import com.ceiba.auto.modelo.entidad.EstadoAuto;
import com.ceiba.auto.servicio.testdatabuilder.AutoTestDataBuilder;
import com.ceiba.cliente.modelo.entidad.EstadoCliente;
import com.ceiba.cliente.servicio.testdatabuilder.ClienteTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionNegocio;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;

public class AlquilerTest {
	
	@Test
	public void validarFechaAlquilerTest() {
		// arrange
        AlquilerTestDataBuilder alquilerTestDataBuilder = new AlquilerTestDataBuilder().conFechaAlquiler(null);
        
        // act - assert
        BasePrueba.assertThrows(() -> alquilerTestDataBuilder.build(), ExcepcionValorObligatorio.class, "Se debe ingresar la fecha de entrega del auto al cliente");
	}
	
	@Test
	public void validarFechaDevolucionTest() {
		// arrange
        AlquilerTestDataBuilder alquilerTestDataBuilder = new AlquilerTestDataBuilder().conFechaDevolucion(null);
        
        // act - assert
        BasePrueba.assertThrows(() -> alquilerTestDataBuilder.build(), ExcepcionValorObligatorio.class, "Se debe ingresar la fecha de devolución del auto por parte del cliente");
	}
	
	@Test
	public void validarFechaAlquilerMenorQueFechaDevolucionTest() {
		// arrange
        AlquilerTestDataBuilder alquilerTestDataBuilder = new AlquilerTestDataBuilder().conFechaAlquiler(LocalDate.now()).conFechaDevolucion(LocalDate.now().minusDays(1));
        
        // act - assert
        BasePrueba.assertThrows(() -> alquilerTestDataBuilder.build(), ExcepcionValorInvalido.class, "La fecha del alquiler debe ser antes de la fecha de devolución");
	}
	
	@Test
	public void validarFechaAlquilerMenorQueFechaSistemaTest() {
		// arrange
        AlquilerTestDataBuilder alquilerTestDataBuilder = new AlquilerTestDataBuilder().conFechaAlquiler(LocalDate.now().minusDays(1));
        
        // act - assert
        BasePrueba.assertThrows(() -> alquilerTestDataBuilder.build(), ExcepcionValorInvalido.class, "La fecha del alquiler debe ser igual o posterior a la fecha de creación");
	}
	
	@Test
	public void validarCalcularSubTotalTest() {
		// arrange
        Alquiler alquiler = new AlquilerTestDataBuilder().conFechaAlquiler(LocalDate.now()).conFechaDevolucion(LocalDate.now().plusDays(4)).build();
        
        // act 
        alquiler.calcularSubTotal();
        
        // assert
        assertEquals(500000.00, alquiler.getSubTotal().doubleValue());
	}
	
	@Test
	public void validarCalcularDescuentosMasDe15DiasTest() {
		// arrange
		Double subTotal = 2000000.00;
        Alquiler alquiler = new AlquilerTestDataBuilder().conSubTotal(subTotal).conFechaCreacion(LocalDateTime.parse("2021-01-15T13:00:00")).conFechaAlquiler(LocalDate.parse("2050-02-01")).conFechaDevolucion(LocalDate.parse("2050-02-20")).build();
        Double descuentos = subTotal * 0.05;
        
        // act 
        alquiler.calcularDescuentos();
        
        // assert
        assertEquals(descuentos.doubleValue(), alquiler.getDescuento().doubleValue());
	}
	
	@Test
	public void validarCalcularDescuentosPrimerosDiasDelMesTest() {
		// arrange
		Double subTotal = 500000.00;
        Alquiler alquiler = new AlquilerTestDataBuilder().conSubTotal(subTotal).conFechaCreacion(LocalDateTime.parse("2021-02-03T13:00:00")).conFechaAlquiler(LocalDate.parse("2050-02-01")).conFechaDevolucion(LocalDate.parse("2050-02-05")).build();
        Double descuentos = subTotal * 0.03;
        
        // act 
        alquiler.calcularDescuentos();
        
        // assert
        assertEquals(descuentos.doubleValue(), alquiler.getDescuento().doubleValue());
	}
	
	@Test
	public void validarCalcularDescuentosMasDe15DiasYPrimerosDiasDelMesTest() {
		// arrange
		Double subTotal = 2000000.00;
        Alquiler alquiler = new AlquilerTestDataBuilder().conSubTotal(subTotal).conFechaCreacion(LocalDateTime.parse("2021-02-01T13:00:00")).conFechaAlquiler(LocalDate.parse("2050-02-01")).conFechaDevolucion(LocalDate.parse("2050-02-20")).build();
        Double descuentos = (subTotal * 0.05) + (subTotal * 0.03);
        
        // act 
        alquiler.calcularDescuentos();
        
        // assert
        assertEquals(descuentos.doubleValue(), alquiler.getDescuento().doubleValue());
	}
	
	@Test
	public void validarCalcularTotalTest() {
		// arrange
		Double subTotal = 500000.00;
		Double descuento = 100000.00;
        Alquiler alquiler = new AlquilerTestDataBuilder().conSubTotal(subTotal).conDescuento(descuento).conFechaAlquiler(LocalDate.parse("2050-02-01")).conFechaDevolucion(LocalDate.parse("2050-02-05")).build();
        
        // act 
        alquiler.calcularTotal();
        
        // assert
        assertEquals(subTotal - descuento, alquiler.getTotal().doubleValue());
	}
	
	@Test
	public void validarFechaCreacionLunesAViernesTest() {
		// arrange
        Alquiler alquiler = new AlquilerTestDataBuilder().conFechaCreacion(LocalDateTime.parse("2021-02-06T13:00:00")).build();
        
        // act - assert
        BasePrueba.assertThrows(() -> alquiler.validarFechaCreacionLunesAViernes(), ExcepcionNegocio.class, "Solo se permite crear el alquiler de Lunes a Viernes");
	}
	
	@Test
	public void validarEstadoDisponibleAutoTest() {
		// arrange
		Alquiler alquiler = new AlquilerTestDataBuilder().conAuto(new AutoTestDataBuilder().conEstado(EstadoAuto.ALQUILADO).build()).build();

        // act - assert
        BasePrueba.assertThrows(() -> alquiler.validarEstadoDisponibleAuto(), ExcepcionNegocio.class, "El auto no está disponible para alquilar");
	}
	
	@Test
	public void validarEstadoActivoCliente() {
		// arrange
		Alquiler alquiler = new AlquilerTestDataBuilder().conCliente(new ClienteTestDataBuilder().conEstado(EstadoCliente.ELIMINADO).build()).build();
        
        // act - assert
        BasePrueba.assertThrows(() -> alquiler.validarEstadoActivoCliente(), ExcepcionNegocio.class, "El cliente no está activo");
	}	

}
