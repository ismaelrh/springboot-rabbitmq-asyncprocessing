package com.colaDos;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * Configura los beans para manejar la colaDos:
 *  * Define la cola, el escuchador, el pool de threads y el proceso periodico.
 *  Si queremos ser el que envia, solo necesitamos definir la cola.
 *  Si somos el que recibe, la cola, el escuchador, el pool de workers.
 *  El proceso periodico podria ir en cualquier parte.
 */
@Configuration
@EnableScheduling
public class QueueConfigurationDos {

    @Bean
    //Registramos la cola dos
    public Queue colaDos() {
        return new Queue("colaDos");
    }

    @Bean
    //Registramos quien escuchara dicha cola
    public ListenerDos listenerDos(){
        return new ListenerDos();
    }

    @Bean
    //Proceso periodico que mete en cola 2
    public ProcesoPeriodicoDos procesoPeriodicoDos() {
        return new ProcesoPeriodicoDos();
    }


    @Bean
    //El pool de threads de la colaDos
    public TaskExecutor taskExecutorDos() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setMaxPoolSize(10); //Si la cola se llena (MAX_INT_VALUE), entonces podremos crear hasta los threads indicados
        taskExecutor.setCorePoolSize(10); //Podemos tener X concurrentemente
        taskExecutor.afterPropertiesSet();
        return taskExecutor;
    }
}
