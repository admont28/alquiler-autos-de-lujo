package com.ceiba.alquiler.adaptador.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.ceiba.alquiler.modelo.entidad.Alquiler;


@Component
public class RecibirMensajeAzureServiceBus {
	
	private static final Logger logger = LoggerFactory.getLogger(RecibirMensajeAzureServiceBus.class);

	private static final String DESTINO = "alquiler";
	
	@JmsListener(destination = DESTINO, containerFactory = "jmsListenerContainerFactory")
    public void receiveMessage(Alquiler alquiler) {
		logger.info("Se recibe mensaje de la cola {}, mensaje: {}", DESTINO, alquiler);
    }
}
