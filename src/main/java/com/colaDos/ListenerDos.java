package com.colaDos;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.task.TaskExecutor;
import org.springframework.messaging.handler.annotation.Payload;

import java.util.Date;

/**
 * Clase encargada de escuchar cuando llega un mensaje a la cola, y actuar en consecuencia.
 */
@RabbitListener(queues="colaDos")
public class ListenerDos {

    @Autowired
    @Qualifier("taskExecutorDos")
    TaskExecutor executor;

    @Autowired
    WorkerDos worker;

    @RabbitHandler
    public void process(@Payload String foo) {
        //Cuando hay mensaje en la cola, se lanza worker a traves del pool
        worker.setParameter(foo); executor.execute(worker);
    }



}
