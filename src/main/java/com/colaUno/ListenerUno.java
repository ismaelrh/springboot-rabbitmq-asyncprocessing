package com.colaUno;

import com.colaDos.WorkerDos;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.task.TaskExecutor;
import org.springframework.messaging.handler.annotation.Payload;

import java.util.Date;

/**
 * Created by ismaro3 on 18/12/15.
 */
@RabbitListener(queues="colaUno")
public class ListenerUno {

    @Autowired
    @Qualifier("taskExecutorUno")
    TaskExecutor executor;

    @Autowired
    WorkerUno worker;

    @RabbitHandler
    public void process(@Payload String foo) {
        //Cuando hay mensaje en la cola, se lanza worker a traves del pool
        worker.setParameter(foo); executor.execute(worker);
    }



}
