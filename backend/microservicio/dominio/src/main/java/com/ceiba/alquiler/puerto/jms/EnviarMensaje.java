package com.ceiba.alquiler.puerto.jms;

import com.ceiba.alquiler.modelo.entidad.Alquiler;

public interface EnviarMensaje {

	public void ejecutar(Alquiler mensaje);
}
