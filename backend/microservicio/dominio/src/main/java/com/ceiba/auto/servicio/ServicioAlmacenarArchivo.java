package com.ceiba.auto.servicio;

import java.io.ByteArrayInputStream;
import java.net.URI;
import java.util.Base64;

import com.ceiba.auto.puerto.almacenamiento.AlmacenamientoAuto;

public class ServicioAlmacenarArchivo {

	private final AlmacenamientoAuto almacenamientoAuto;

	public ServicioAlmacenarArchivo(AlmacenamientoAuto almacenamientoAuto) {
		this.almacenamientoAuto = almacenamientoAuto;
	}
	
	public URI ejecutar(String archivoBase64) {
		return almacenamientoAuto.cargarImagen(new ByteArrayInputStream(Base64.getDecoder().decode(archivoBase64)));
	}
	
	
}
