package com.ceiba.alquiler.servicio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.alquiler.modelo.entidad.Alquiler;
import com.ceiba.alquiler.puerto.repositorio.RepositorioAlquiler;
import com.ceiba.alquiler.servicio.testdatabuilder.AlquilerTestDataBuilder;
import com.ceiba.auto.modelo.entidad.EstadoAuto;
import com.ceiba.auto.servicio.testdatabuilder.AutoTestDataBuilder;
import com.ceiba.cliente.modelo.entidad.EstadoCliente;
import com.ceiba.cliente.servicio.testdatabuilder.ClienteTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionNegocio;

public class ServicioCrearAlquilerTest {
	
	@Test
	public void validarEstadoDisponibleAutoTest() {
		// arrange
		Alquiler alquiler = new AlquilerTestDataBuilder().conAuto(new AutoTestDataBuilder().conEstado(EstadoAuto.ALQUILADO).build()).build();
		RepositorioAlquiler repositorioAlquiler = Mockito.mock(RepositorioAlquiler.class);
        Mockito.when(repositorioAlquiler.crear(Mockito.anyObject())).thenReturn(1L);
        ServicioCrearAlquiler servicioCrearAlquiler = new ServicioCrearAlquiler(repositorioAlquiler);
		
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearAlquiler.ejecutar(alquiler), ExcepcionNegocio.class, "El auto no está disponible para alquilar");
	}
	
	@Test
	public void validarEstadoActivoCliente() {
		// arrange
		Alquiler alquiler = new AlquilerTestDataBuilder().conCliente(new ClienteTestDataBuilder().conEstado(EstadoCliente.ELIMINADO).build()).build();
        RepositorioAlquiler repositorioAlquiler = Mockito.mock(RepositorioAlquiler.class);
        Mockito.when(repositorioAlquiler.crear(Mockito.anyObject())).thenReturn(1L);
        ServicioCrearAlquiler servicioCrearAlquiler = new ServicioCrearAlquiler(repositorioAlquiler);
        
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearAlquiler.ejecutar(alquiler), ExcepcionNegocio.class, "El cliente no está activo");
	}
    
    @Test
    public void crearAlquilerTest() {
        // arrange
        Alquiler alquiler = new AlquilerTestDataBuilder().build();
        RepositorioAlquiler repositorioAlquiler = Mockito.mock(RepositorioAlquiler.class);
        Mockito.when(repositorioAlquiler.crear(Mockito.anyObject())).thenReturn(1L);
        ServicioCrearAlquiler servicioCrearAlquiler = new ServicioCrearAlquiler(repositorioAlquiler);
        
        // act 
        Long alquilerIdCreado = servicioCrearAlquiler.ejecutar(alquiler);
        
        // assert
        assertEquals(1L, alquilerIdCreado.longValue());
    }
    
    
}
