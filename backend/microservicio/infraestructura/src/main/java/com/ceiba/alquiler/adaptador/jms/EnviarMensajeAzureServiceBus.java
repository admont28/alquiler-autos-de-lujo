package com.ceiba.alquiler.adaptador.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.ceiba.alquiler.modelo.entidad.Alquiler;
import com.ceiba.alquiler.puerto.jms.EnviarMensaje;

@Service
public class EnviarMensajeAzureServiceBus implements EnviarMensaje {
	
	private static final Logger logger = LoggerFactory.getLogger(EnviarMensajeAzureServiceBus.class);
	
	@Value("${spring.jms.servicebus.queue-name}")
	private String destino;
	
	private final JmsTemplate jmsTemplate;

	public EnviarMensajeAzureServiceBus(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
	
	@Override
	public void ejecutar(Alquiler mensaje) {
		this.jmsTemplate.convertAndSend(destino, mensaje);
		logger.info("Se envia mensaje a la cola {}, mensaje: {}", destino, mensaje);
	}

}
