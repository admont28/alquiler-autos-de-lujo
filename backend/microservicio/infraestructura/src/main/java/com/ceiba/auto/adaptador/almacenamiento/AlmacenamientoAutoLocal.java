package com.ceiba.auto.adaptador.almacenamiento;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.ceiba.auto.puerto.almacenamiento.AlmacenamientoAuto;
import com.ceiba.infraestructura.excepcion.ExcepcionTecnica;

@Service
public class AlmacenamientoAutoLocal implements AlmacenamientoAuto{

	@Override
	public URI cargarImagen(InputStream imagen) {
		URI uri = null;
		try {
			String nombreImagen = UUID.randomUUID().toString();
			Files.copy(imagen, Paths.get("../../frontend/angular-base/src/assets/uploads").resolve(nombreImagen));
			uri = new URI("assets/uploads/"+nombreImagen);
		} catch (IOException | URISyntaxException e) {
			throw new ExcepcionTecnica("Ocurrió un error al cargar el archivo", e);
		}
		return uri;
	}

}
