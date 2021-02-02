package com.ceiba.alquiler.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.alquiler.comando.ComandoAlquiler;
import com.ceiba.alquiler.modelo.entidad.Alquiler;
import com.ceiba.auto.modelo.entidad.Auto;
import com.ceiba.cliente.modelo.entidad.Cliente;

@Component
public class FabricaAlquiler {

    public Alquiler crear(ComandoAlquiler comandoAlquiler, Auto auto, Cliente cliente) {
        return new Alquiler(
        		comandoAlquiler.getId(), 
        		auto,
        		cliente,
        		comandoAlquiler.getFechaAlquiler(),
        		comandoAlquiler.getFechaDevolucion()
        );
    }

}
