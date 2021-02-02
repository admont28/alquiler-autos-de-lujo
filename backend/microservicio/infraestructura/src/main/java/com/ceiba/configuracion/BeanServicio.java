package com.ceiba.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.alquiler.puerto.repositorio.RepositorioAlquiler;
import com.ceiba.alquiler.servicio.ServicioCrearAlquiler;
import com.ceiba.auto.puerto.repositorio.RepositorioAuto;
import com.ceiba.auto.servicio.ServicioActualizarAuto;
import com.ceiba.auto.servicio.ServicioCrearAuto;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.cliente.servicio.ServicioActualizarCliente;
import com.ceiba.cliente.servicio.ServicioCrearCliente;
import com.ceiba.cliente.servicio.ServicioEliminarCliente;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioActualizarUsuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioCrearUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioEliminarUsuario servicioEliminarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioEliminarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioActualizarUsuario servicioActualizarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioActualizarUsuario(repositorioUsuario);
    }
    
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
    public ServicioCrearAlquiler servicioCrearAlquiler(RepositorioAlquiler repositorioAlquiler) {
    	return new ServicioCrearAlquiler(repositorioAlquiler);
    }

}
