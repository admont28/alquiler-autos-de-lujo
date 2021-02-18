package com.ceiba.auto.adaptador.almacenamiento;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.ceiba.auto.puerto.almacenamiento.AlmacenamientoAuto;
import com.ceiba.infraestructura.excepcion.ExcepcionTecnica;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlockBlob;

@Service
public class AlmacenamientoAutoAzureBlobStorage implements AlmacenamientoAuto{
	
	private final CloudBlobContainer cloudBlobContainer;

	public AlmacenamientoAutoAzureBlobStorage(CloudBlobContainer cloudBlobContainer) {
		this.cloudBlobContainer = cloudBlobContainer;
	}

	@Override
	public URI cargarImagen(InputStream imagen) {
		URI uri = null;
		try {
			CloudBlockBlob blob = cloudBlobContainer.getBlockBlobReference(UUID.randomUUID().toString());
			blob.upload(imagen, -1);
			uri = blob.getUri();
		} catch (URISyntaxException | StorageException | IOException e) {
			throw new ExcepcionTecnica("Ocurrió un error al cargar el archivo", e);
		}
		return uri;
	}

}
