package com.ceiba.auto.puerto.almacenamiento;

import java.io.InputStream;
import java.net.URI;

public interface AlmacenamientoAuto {

	public URI cargarImagen(InputStream imagen);
}
