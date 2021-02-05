package com.ceiba.cliente.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.cliente.consulta.ManejadorListarCliente;
import com.ceiba.cliente.modelo.dto.DTOCliente;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/clientes")
@Api(tags = { "Controlador consulta cliente"})
public class ConsultaControladorCliente {

    private final ManejadorListarCliente manejadorListarCliente;

    @Autowired
    public ConsultaControladorCliente(ManejadorListarCliente manejadorListarAlquiler) {
        this.manejadorListarCliente = manejadorListarAlquiler;
    }

    @GetMapping
    @ApiOperation("Listar Clientes")
    public List<DTOCliente> listar() {
        return manejadorListarCliente.ejecutar();
    }
}
