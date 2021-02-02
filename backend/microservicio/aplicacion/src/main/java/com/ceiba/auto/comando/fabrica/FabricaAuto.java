package com.ceiba.auto.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.auto.comando.ComandoAuto;
import com.ceiba.auto.modelo.entidad.Auto;

@Component
public class FabricaAuto {

    public Auto crear(ComandoAuto comandoAuto) {
        return new Auto(
                comandoAuto.getId(),
                comandoAuto.getSerial(),
                comandoAuto.getNombre(),
                comandoAuto.getModelo(),
                comandoAuto.getPrecioPorDia()
        );
    }

}
