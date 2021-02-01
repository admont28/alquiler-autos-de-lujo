package com.ceiba.alquiler.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.ComandoRespuesta;
import com.ceiba.alquiler.comando.ComandoAlquiler;
import com.ceiba.alquiler.comando.manejador.ManejadorCrearAlquiler;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/alquiler")
@Api(tags = { "Controlador comando alquiler"})
public class ComandoControladorAlquiler {

    private final ManejadorCrearAlquiler manejadorCrearAlquiler;

    @Autowired
    public ComandoControladorAlquiler(ManejadorCrearAlquiler manejadorCrearAlquiler) {
        this.manejadorCrearAlquiler = manejadorCrearAlquiler;
    }

    @PostMapping
    @ApiOperation("Crear Alquiler")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoAlquiler comandoAlquiler) {
        return manejadorCrearAlquiler.ejecutar(comandoAlquiler);
    }
}
