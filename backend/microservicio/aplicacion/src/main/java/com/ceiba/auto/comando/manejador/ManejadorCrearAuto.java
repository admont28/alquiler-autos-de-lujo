package com.ceiba.auto.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.ComandoRespuesta;
import com.ceiba.auto.comando.ComandoAuto;
import com.ceiba.auto.comando.fabrica.FabricaAuto;
import com.ceiba.auto.servicio.ServicioCrearAuto;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.usuario.modelo.entidad.Auto;

@Component
public class ManejadorCrearAuto implements ManejadorComandoRespuesta<ComandoAuto, ComandoRespuesta<Long>> {

    private final FabricaAuto fabricaAuto;
    private final ServicioCrearAuto servicioCrearAuto;

    public ManejadorCrearAuto(FabricaAuto fabricaAuto, ServicioCrearAuto servicioCrearAuto) {
        this.fabricaAuto = fabricaAuto;
        this.servicioCrearAuto = servicioCrearAuto;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoAuto comandoAuto) {
        Auto auto = this.fabricaAuto.crear(comandoAuto);
        return new ComandoRespuesta<>(this.servicioCrearAuto.ejecutar(auto));
    }
}
