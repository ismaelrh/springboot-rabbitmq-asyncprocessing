package com.colaUno;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * Clase encargada de meter periodicamente mensajes en la cola uno.
 */
public class ProcesoPeriodicoUno {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Scheduled(fixedDelay = 1000L)
	public void send() {
		 this.rabbitTemplate.convertAndSend("colaUno", "Mensaje periodico de cola Uno");
	}

}