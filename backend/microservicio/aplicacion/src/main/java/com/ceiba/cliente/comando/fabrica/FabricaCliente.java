package com.ceiba.cliente.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.cliente.comando.ComandoCliente;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.modelo.entidad.EstadoCliente;

@Component
public class FabricaCliente {

    public Cliente crear(ComandoCliente comandoCliente) {
        return new Cliente(
                comandoCliente.getId(),
                comandoCliente.getNombre(),
                comandoCliente.getApellido(),
                comandoCliente.getDireccion(),
                comandoCliente.getCedula(),
                comandoCliente.getEstado() != null ? EstadoCliente.valueOf(comandoCliente.getEstado()) : null
        );
    }

}
