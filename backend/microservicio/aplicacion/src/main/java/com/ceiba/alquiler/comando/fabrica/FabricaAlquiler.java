package com.ceiba.alquiler.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.alquiler.comando.ComandoAlquiler;
import com.ceiba.alquiler.modelo.entidad.Alquiler;

@Component
public class FabricaAlquiler {

    public Alquiler crear(ComandoAlquiler comandoAlquiler) {
        return new Alquiler(
        		comandoAlquiler.getId(), 
        		comandoAlquiler.getFechaAlquiler(),
        		comandoAlquiler.getFechaDevolucion()
        );
    }

}
