package com.ceiba.auto.servicio;

import static org.mockito.Mockito.atLeastOnce;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.auto.modelo.entidad.Auto;
import com.ceiba.auto.puerto.repositorio.RepositorioAuto;
import com.ceiba.auto.servicio.testdatabuilder.AutoTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioActualizarAutoTest {
	

    @Test
    public void validarAutoExistenciaPreviaTest() {
        // arrange
        Auto auto = new AutoTestDataBuilder().build();
        RepositorioAuto repositorioAuto = Mockito.mock(RepositorioAuto.class);
        Mockito.when(repositorioAuto.existeExcluyendoId(Mockito.anyLong(), Mockito.anyString())).thenReturn(true);
        ServicioActualizarAuto servicioActualizarAuto = new ServicioActualizarAuto(repositorioAuto);
        
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarAuto.ejecutar(auto), ExcepcionDuplicidad.class,"El auto ya existe en el sistema");
    }
    
    @Test
    public void actualizarAutoTest() {
        // arrange
        Auto auto = new AutoTestDataBuilder().build();
        RepositorioAuto repositorioAuto = Mockito.mock(RepositorioAuto.class);
        Mockito.when(repositorioAuto.existeExcluyendoId(Mockito.anyLong(), Mockito.anyString())).thenReturn(false);
        ServicioActualizarAuto servicioActualizarAuto = new ServicioActualizarAuto(repositorioAuto);
        
        // act 
        servicioActualizarAuto.ejecutar(auto);
        
        // assert
        Mockito.verify(repositorioAuto, atLeastOnce()).actualizar(auto);
    }
    
    
}
