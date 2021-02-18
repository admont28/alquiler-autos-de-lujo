package com.ceiba.auto.comando.manejador;

import java.net.URI;

import org.springframework.stereotype.Component;

import com.ceiba.ComandoRespuesta;
import com.ceiba.auto.comando.ComandoAuto;
import com.ceiba.auto.comando.fabrica.FabricaAuto;
import com.ceiba.auto.modelo.entidad.Auto;
import com.ceiba.auto.servicio.ServicioAlmacenarArchivo;
import com.ceiba.auto.servicio.ServicioCrearAuto;
import com.ceiba.manejador.ManejadorComandoRespuesta;

@Component
public class ManejadorCrearAuto implements ManejadorComandoRespuesta<ComandoAuto, ComandoRespuesta<Long>> {

    private final FabricaAuto fabricaAuto;
    private final ServicioCrearAuto servicioCrearAuto;
    private final ServicioAlmacenarArchivo servicioAlmacenarArchivo;

    public ManejadorCrearAuto(FabricaAuto fabricaAuto, ServicioCrearAuto servicioCrearAuto, ServicioAlmacenarArchivo servicioAlmacenarArchivo) {
        this.fabricaAuto = fabricaAuto;
        this.servicioCrearAuto = servicioCrearAuto;
		this.servicioAlmacenarArchivo = servicioAlmacenarArchivo;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoAuto comandoAuto) {
    	URI uriImagen = servicioAlmacenarArchivo.ejecutar(comandoAuto.getImagen());
    	comandoAuto.setImagen(uriImagen.toString());
        Auto auto = this.fabricaAuto.crear(comandoAuto);
        return new ComandoRespuesta<>(this.servicioCrearAuto.ejecutar(auto));
    }
}
