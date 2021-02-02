package com.ceiba.alquiler.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.ComandoRespuesta;
import com.ceiba.alquiler.comando.ComandoAlquiler;
import com.ceiba.alquiler.comando.fabrica.FabricaAlquiler;
import com.ceiba.alquiler.modelo.entidad.Alquiler;
import com.ceiba.alquiler.servicio.ServicioCrearAlquiler;
import com.ceiba.auto.modelo.entidad.Auto;
import com.ceiba.auto.puerto.repositorio.RepositorioAuto;
import com.ceiba.auto.servicio.ServicioActualizarAuto;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.manejador.ManejadorComandoRespuesta;

@Component
public class ManejadorCrearAlquiler implements ManejadorComandoRespuesta<ComandoAlquiler, ComandoRespuesta<Long>> {

    private final FabricaAlquiler fabricaAlquiler;
    private final ServicioCrearAlquiler servicioCrearAlquiler;
    private final ServicioActualizarAuto servicioActualizarAuto;
    private final RepositorioAuto repositorioAuto;
    private final RepositorioCliente repositorioCliente;

    public ManejadorCrearAlquiler(FabricaAlquiler fabricaAlquiler, ServicioCrearAlquiler servicioCrearAlquiler, RepositorioAuto repositorioAuto, RepositorioCliente repositorioCliente, ServicioActualizarAuto servicioActualizarAuto) {
        this.fabricaAlquiler = fabricaAlquiler;
        this.servicioCrearAlquiler = servicioCrearAlquiler;
		this.repositorioAuto = repositorioAuto;
		this.repositorioCliente = repositorioCliente;
		this.servicioActualizarAuto = servicioActualizarAuto;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoAlquiler comandoAlquiler) {
        Auto auto = this.repositorioAuto.buscar(comandoAlquiler.getAutoId());
        Cliente cliente = this.repositorioCliente.buscar(comandoAlquiler.getClienteId());
        
    	Alquiler alquiler = this.fabricaAlquiler.crear(comandoAlquiler, auto, cliente);
    	
    	Long id = this.servicioCrearAlquiler.ejecutar(alquiler);
    	this.servicioActualizarAuto.ejecutar(auto);
    	
        return new ComandoRespuesta<>(id);
    }
}
