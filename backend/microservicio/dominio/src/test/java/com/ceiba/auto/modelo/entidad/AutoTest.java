package com.ceiba.auto.modelo.entidad;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import com.ceiba.BasePrueba;
import com.ceiba.auto.servicio.testdatabuilder.AutoTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;

public class AutoTest {

	@Test
	public void validarSerialAutoTest() {
		// arrange
        AutoTestDataBuilder autoTestDataBuilder = new AutoTestDataBuilder().conSerial(null);
        
        // act - assert
        BasePrueba.assertThrows(() -> autoTestDataBuilder.build(), ExcepcionValorObligatorio.class, "Se debe ingresar el serial del auto");
	}
	
	@Test
	public void validarLongitudSerialAutoTest() {
		// arrange
        AutoTestDataBuilder autoTestDataBuilder = new AutoTestDataBuilder().conSerial("12");
        
        // act - assert
        BasePrueba.assertThrows(() -> autoTestDataBuilder.build(), ExcepcionLongitudValor.class, "El serial debe tener mínimo 3 caracteres");
	}
	
	@Test
	public void validarNombreAutoTest() {
		// arrange
        AutoTestDataBuilder autoTestDataBuilder = new AutoTestDataBuilder().conNombre(null);
        
        // act - assert
        BasePrueba.assertThrows(() -> autoTestDataBuilder.build(), ExcepcionValorObligatorio.class, "Se debe ingresar el nombre del auto");
	}
	
	@Test
	public void validarLongitudNombreAutoTest() {
		// arrange
        AutoTestDataBuilder autoTestDataBuilder = new AutoTestDataBuilder().conNombre("au");
        
        // act - assert
        BasePrueba.assertThrows(() -> autoTestDataBuilder.build(), ExcepcionLongitudValor.class, "El nombre debe tener mínimo 3 caracteres");
	}
	
	@Test
	public void validarModeloAutoTest() {
		// arrange
        AutoTestDataBuilder autoTestDataBuilder = new AutoTestDataBuilder().conModelo(null);
        
        // act - assert
        BasePrueba.assertThrows(() -> autoTestDataBuilder.build(), ExcepcionValorObligatorio.class, "Se debe ingresar el modelo del auto");
	}
	
	@Test
	public void validarLongitudModeloAutoTest() {
		// arrange
        AutoTestDataBuilder autoTestDataBuilder = new AutoTestDataBuilder().conModelo("20");
        
        // act - assert
        BasePrueba.assertThrows(() -> autoTestDataBuilder.build(), ExcepcionLongitudValor.class, "El modelo debe tener mínimo 3 caracteres");
	}
	
	@Test
	public void validarPrecioPorDiaAutoTest() {
		// arrange
        AutoTestDataBuilder autoTestDataBuilder = new AutoTestDataBuilder().conPrecioPorDia(null);
        
        // act - assert
        BasePrueba.assertThrows(() -> autoTestDataBuilder.build(), ExcepcionValorObligatorio.class, "Se debe ingresar el precio por día del auto");
	}
	
	@Test
	public void validarPositivoPrecioPorDiaAutoTest() {
		// arrange
        AutoTestDataBuilder autoTestDataBuilder = new AutoTestDataBuilder().conPrecioPorDia(-100000.00);
        
        // act - assert
        BasePrueba.assertThrows(() -> autoTestDataBuilder.build(), ExcepcionValorInvalido.class, "El precio por día del auto debe ser un valor positivo");
	}
	
	@Test
	public void validarCambioEstadoAutoAlquiladoTest() {
		// arrange
        Auto auto = new AutoTestDataBuilder().build();
        
        // act 
        auto.cambiarEstadoAutoAlquilado();
        
        // assert
        assertEquals(EstadoAuto.ALQUILADO, auto.getEstado());
	}

}
