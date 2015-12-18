package com.colaDos;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * Clase encargada de meter periodicamente mensajes en la cola dos.
 */
public class ProcesoPeriodicoDos {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Scheduled(fixedDelay = 1000L)
	public void send() {
		 this.rabbitTemplate.convertAndSend("colaDos", "Mensaje periodico de cola Dos");
	}

}