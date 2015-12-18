package com;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Clase encargada de enviar un mensaje a una cola.
 */
public class Sender {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void send(String cola, String mensaje) {
		 this.rabbitTemplate.convertAndSend(cola,mensaje);
	}

}