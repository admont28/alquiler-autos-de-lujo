package com.ceiba.auto.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.auto.comando.ComandoAuto;
import com.ceiba.auto.comando.manejador.ManejadorCrearAuto;
import com.ceiba.usuario.comando.ComandoUsuario;
import com.ceiba.usuario.comando.manejador.ManejadorActualizarUsuario;
import com.ceiba.usuario.comando.manejador.ManejadorCrearUsuario;
import com.ceiba.usuario.comando.manejador.ManejadorEliminarUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/autos")
@Api(tags = { "Controlador comando auto"})
public class ComandoControladorAuto {

	private final ManejadorCrearAuto manejadorCrearAuto;

    @Autowired
    public ComandoControladorAuto(ManejadorCrearAuto manejadorCrearAuto) {
        this.manejadorCrearAuto = manejadorCrearAuto;
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
//	@PutMapping(value="/{id}")
//	@ApiOperation("Actualizar Usuario")
//	public void actualizar(@RequestBody ComandoUsuario comandoUsuario,@PathVariable Long id) {
//		comandoUsuario.setId(id);
//		manejadorActualizarUsuario.ejecutar(comandoUsuario);
//	}
}
