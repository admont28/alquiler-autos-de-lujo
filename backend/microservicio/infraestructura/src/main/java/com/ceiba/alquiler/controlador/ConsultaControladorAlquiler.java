package com.ceiba.alquiler.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.alquiler.consulta.ManejadorListarAlquiler;
import com.ceiba.alquiler.modelo.dto.DTOAlquiler;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/alquiler")
@Api(tags = { "Controlador consulta alquiler"})
public class ConsultaControladorAlquiler {

    private final ManejadorListarAlquiler manejadorListarAlquiler;

    @Autowired
    public ConsultaControladorAlquiler(ManejadorListarAlquiler manejadorListarAlquiler) {
        this.manejadorListarAlquiler = manejadorListarAlquiler;
    }

    @GetMapping
    @ApiOperation("Listar Alquileres")
    public List<DTOAlquiler> listar() {
        return manejadorListarAlquiler.ejecutar();
    }
}
