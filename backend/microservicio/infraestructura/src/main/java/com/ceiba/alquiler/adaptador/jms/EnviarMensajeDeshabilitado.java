package com.ceiba.alquiler.adaptador.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ceiba.alquiler.modelo.entidad.Alquiler;
import com.ceiba.alquiler.puerto.jms.EnviarMensaje;

@Service
public class EnviarMensajeDeshabilitado implements EnviarMensaje {
	
	private static final Logger logger = LoggerFactory.getLogger(EnviarMensajeDeshabilitado.class);
	
	@Override
	public void ejecutar(Alquiler mensaje) {
		logger.info("Deshabilitado el servicio de enviar mensaje a la cola.");
	}

}
