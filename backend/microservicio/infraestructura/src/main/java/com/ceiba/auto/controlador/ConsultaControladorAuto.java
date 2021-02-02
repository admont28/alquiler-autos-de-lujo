package com.ceiba.auto.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.auto.consulta.ManejadorListarAuto;
import com.ceiba.auto.modelo.dto.DTOAuto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/autos")
@Api(tags = { "Controlador consulta auto"})
public class ConsultaControladorAuto {

    private final ManejadorListarAuto manejadorListarAuto;

    @Autowired
    public ConsultaControladorAuto(ManejadorListarAuto manejadorListarAlquiler) {
        this.manejadorListarAuto = manejadorListarAlquiler;
    }

    @GetMapping
    @ApiOperation("Listar Autos")
    public List<DTOAuto> listar() {
        return manejadorListarAuto.ejecutar();
    }
}
