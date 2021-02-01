package com.ceiba.auto.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.ComandoRespuesta;
import com.ceiba.auto.comando.ComandoAuto;
import com.ceiba.auto.comando.manejador.ManejadorActualizarAuto;
import com.ceiba.auto.comando.manejador.ManejadorCrearAuto;
import com.ceiba.usuario.comando.ComandoUsuario;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/autos")
@Api(tags = { "Controlador comando auto"})
public class ComandoControladorAuto {

	private final ManejadorCrearAuto manejadorCrearAuto;
	private final ManejadorActualizarAuto manejadorActualizarAuto;

    @Autowired
    public ComandoControladorAuto(ManejadorCrearAuto manejadorCrearAuto, ManejadorActualizarAuto manejadorActualizarAuto) {
        this.manejadorCrearAuto = manejadorCrearAuto;
        this.manejadorActualizarAuto = manejadorActualizarAuto;
    }

    @PostMapping
    @ApiOperation("Crear Auto")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoAuto comandoAuto) {
        return manejadorCrearAuto.ejecutar(comandoAuto);
    }

//    @DeleteMapping(value="/{id}")
//	@ApiOperation("Eliminar Usuario")
//	public void eliminar(@PathVariable Long id) {
//		manejadorEliminarUsuario.ejecutar(id);
//	}
//
	@PutMapping(value="/{id}")
	@ApiOperation("Actualizar A")
	public void actualizar(@RequestBody ComandoAuto comandoAuto, @PathVariable Long id) {
		comandoAuto.setId(id);
		manejadorActualizarAuto.ejecutar(comandoAuto);
	}
}
