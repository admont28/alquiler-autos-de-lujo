package com.ceiba.auto.servicio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.auto.modelo.entidad.Auto;
import com.ceiba.auto.puerto.repositorio.RepositorioAuto;
import com.ceiba.auto.servicio.testdatabuilder.AutoTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;

public class ServicioCrearAutoTest {
	
	@Test
	public void validarSerialAutoTest() {
		// arrange
        AutoTestDataBuilder autoTestDataBuilder = new AutoTestDataBuilder().conSerial(null);
        
        // act - assert
        BasePrueba.assertThrows(() -> autoTestDataBuilder.build(), ExcepcionValorObligatorio.class, "Se debe ingresar el serial del auto");
	}
	
	@Test
	public void validarNombreAutoTest() {
		// arrange
        AutoTestDataBuilder autoTestDataBuilder = new AutoTestDataBuilder().conNombre(null);
        
        // act - assert
        BasePrueba.assertThrows(() -> autoTestDataBuilder.build(), ExcepcionValorObligatorio.class, "Se debe ingresar el nombre del auto");
	}
	
	@Test
	public void validarModeloAutoTest() {
		// arrange
        AutoTestDataBuilder autoTestDataBuilder = new AutoTestDataBuilder().conModelo(null);
        
        // act - assert
        BasePrueba.assertThrows(() -> autoTestDataBuilder.build(), ExcepcionValorObligatorio.class, "Se debe ingresar el modelo del auto");
	}
	
	@Test
	public void validarPrecioPorDiaAutoTest() {
		// arrange
        AutoTestDataBuilder autoTestDataBuilder = new AutoTestDataBuilder().conPrecioPorDia(null);
        
        // act - assert
        BasePrueba.assertThrows(() -> autoTestDataBuilder.build(), ExcepcionValorObligatorio.class, "Se debe ingresar el precio por día del auto");
	}

    @Test
    public void validarAutoExistenciaPreviaTest() {
        // arrange
        Auto auto = new AutoTestDataBuilder().build();
        RepositorioAuto repositorioAuto = Mockito.mock(RepositorioAuto.class);
        Mockito.when(repositorioAuto.existe(Mockito.anyString())).thenReturn(true);
        ServicioCrearAuto servicioCrearAuto = new ServicioCrearAuto(repositorioAuto);
        
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearAuto.ejecutar(auto), ExcepcionDuplicidad.class,"El auto ya existe en el sistema");
    }
    
    @Test
    public void crearAutoTest() {
        // arrange
        Auto auto = new AutoTestDataBuilder().build();
        RepositorioAuto repositorioAuto = Mockito.mock(RepositorioAuto.class);
        Mockito.when(repositorioAuto.existe(Mockito.anyString())).thenReturn(false);
        Mockito.when(repositorioAuto.crear(Mockito.anyObject())).thenReturn(1L);
        ServicioCrearAuto servicioCrearAuto = new ServicioCrearAuto(repositorioAuto);
        
        // act 
        Long autoId = servicioCrearAuto.ejecutar(auto);
        
        // assert
        assertEquals(auto.getId(), autoId);
    }
    
    
}
