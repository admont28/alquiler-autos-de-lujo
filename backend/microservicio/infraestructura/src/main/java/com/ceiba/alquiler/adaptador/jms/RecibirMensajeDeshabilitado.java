package com.ceiba.alquiler.adaptador.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.ceiba.alquiler.modelo.entidad.Alquiler;


@Component
public class RecibirMensajeDeshabilitado {
	
	private static final Logger logger = LoggerFactory.getLogger(RecibirMensajeDeshabilitado.class);

	private static final String DESTINO = "alquiler";
	
	@JmsListener(destination = DESTINO, containerFactory = "jmsListenerContainerFactory")
    public void receiveMessage(Alquiler alquiler) {
		logger.info("Deshabilitado el servicio de recibir mensaje de la cola.");
    }
}
