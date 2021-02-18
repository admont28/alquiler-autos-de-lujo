package com.ceiba;

import javax.jms.ConnectionFactory;

import org.apache.qpid.jms.JmsConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;

import com.azure.spring.autoconfigure.jms.ConnectionStringResolver;
import com.azure.spring.autoconfigure.jms.ServiceBusKey;

@Configuration
public class Configuracion {

	@Value("${spring.jms.servicebus.connection-string}")
	private String connectionString;
	
	@Value("${spring.jms.servicebus.idle-timeout}")
	private String idleTimeout;
	
	@Value("${spring.application.name:alquiler-autos-de-lujo-default-app}")
    private String clientId;
	
	@Bean
	public ConnectionFactory jmsConnectionFactory() {
		ServiceBusKey serviceBusKey = ConnectionStringResolver.getServiceBusKey(connectionString);
		String connection = String.format("amqps://%s?amqp.idleTimeout=%s", serviceBusKey.getHost(), idleTimeout);
		System.out.println("Connection: " + connection);
		System.out.println("Client id: " + clientId);
		JmsConnectionFactory jmsConnectionFactory = new JmsConnectionFactory(connection);
		jmsConnectionFactory.setUsername(serviceBusKey.getSharedAccessKeyName());
		jmsConnectionFactory.setPassword(serviceBusKey.getSharedAccessKey());
		jmsConnectionFactory.setClientID(clientId);
		jmsConnectionFactory.setReceiveLocalOnly(true);
		return new CachingConnectionFactory(jmsConnectionFactory);
	}

	@Bean
	public JmsTemplate jmsTemplate(ConnectionFactory jmsConnectionFactory) {
		JmsTemplate returnValue = new JmsTemplate();
		returnValue.setConnectionFactory(jmsConnectionFactory);
		return returnValue;
	}
}
