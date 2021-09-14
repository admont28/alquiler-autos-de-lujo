package com.ceiba.configuracion;

import java.net.URISyntaxException;
import java.security.InvalidKeyException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.alquiler.puerto.jms.EnviarMensaje;
import com.ceiba.alquiler.puerto.repositorio.RepositorioAlquiler;
import com.ceiba.alquiler.servicio.ServicioCrearAlquiler;
import com.ceiba.auto.adaptador.almacenamiento.AlmacenamientoAutoLocal;
import com.ceiba.auto.puerto.almacenamiento.AlmacenamientoAuto;
import com.ceiba.auto.puerto.repositorio.RepositorioAuto;
import com.ceiba.auto.servicio.ServicioActualizarAuto;
import com.ceiba.auto.servicio.ServicioAlmacenarArchivo;
import com.ceiba.auto.servicio.ServicioCrearAuto;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.cliente.servicio.ServicioActualizarCliente;
import com.ceiba.cliente.servicio.ServicioCrearCliente;
import com.ceiba.cliente.servicio.ServicioEliminarCliente;
import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;

@Configuration
public class BeanServicio {
	
	@Value("${spring.azure.blob.store.connectionString}")
	private String storageConnectionString;
	
	@Value("${spring.azure.blob.store.containerName}")
	private String storageContainerName;
	
    @Bean
    public ServicioCrearAuto servicioCrearAuto(RepositorioAuto repositorioAuto) {
    	return new ServicioCrearAuto(repositorioAuto);
    }
    
    @Bean
    public ServicioActualizarAuto servicioActualizarAuto(RepositorioAuto repositorioAuto) {
    	return new ServicioActualizarAuto(repositorioAuto);
    }
    
    @Bean
    public ServicioCrearCliente servicioCrearCliente(RepositorioCliente repositorioCliente) {
    	return new ServicioCrearCliente(repositorioCliente);
    }
    
    @Bean
    public ServicioActualizarCliente servicioActualizarCliente(RepositorioCliente repositorioCliente) {
    	return new ServicioActualizarCliente(repositorioCliente);
    }
    
    @Bean
    public ServicioEliminarCliente servicioEliminarCliente(RepositorioCliente repositorioCliente) {
    	return new ServicioEliminarCliente(repositorioCliente);
    }
	
    @Bean
    public ServicioCrearAlquiler servicioCrearAlquiler(RepositorioAlquiler repositorioAlquiler, EnviarMensaje enviarMensaje) {
    	return new ServicioCrearAlquiler(repositorioAlquiler, enviarMensaje);
    }
    
    @Bean
    public ServicioAlmacenarArchivo servicioAlmacenarArchivo(AlmacenamientoAuto almacenamientoAuto) {
    	return new ServicioAlmacenarArchivo(almacenamientoAuto);
    }
    
    @Bean
    public AlmacenamientoAuto almacenamientoAuto() {
    	return new AlmacenamientoAutoLocal();
    }

    @Bean
    public CloudBlobContainer blobContainer() throws InvalidKeyException, URISyntaxException, StorageException {
    	CloudStorageAccount cloudStorageAccount = CloudStorageAccount.parse(storageConnectionString);
        CloudBlobClient blobClient = cloudStorageAccount.createCloudBlobClient();
        return blobClient.getContainerReference(storageContainerName);
    }
    
}
