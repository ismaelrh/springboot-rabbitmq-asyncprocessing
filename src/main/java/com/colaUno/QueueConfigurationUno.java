package com.colaUno;

import com.colaDos.ProcesoPeriodicoDos;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * Created by ismaro3 on 18/12/15.
 */
@Configuration
@EnableScheduling
/**
 * Configura los beans para manejar la colaUno:
 *  * Define la cola, el escuchador, el pool de threads y el proceso periodico.
 *  Si queremos ser el que envia, solo necesitamos definir la cola.
 *  Si somos el que recibe, la cola, el escuchador, el pool de workers.
 *  El proceso periodico podria ir en cualquier parte.
 */
public class QueueConfigurationUno {

    @Bean
    //Registramos la cola uno
    public Queue colaUno() {
        return new Queue("colaUno");
    }

    @Bean
    //Registramos quien escuchara dicha cola
    public ListenerUno listenerUno(){
        return new ListenerUno();
    }

    @Bean
    //Proceso periodico que mete en cola uno
    public ProcesoPeriodicoUno procesoPeriodicoUno() {
        return new ProcesoPeriodicoUno();
    }

    @Bean
    //El pool de threads de la colaUno
    public TaskExecutor taskExecutorUno() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setMaxPoolSize(10); //Si la cola se llena (MAX_INT_VALUE), entonces podremos crear hasta los threads indicados
        taskExecutor.setCorePoolSize(10); //Podemos tener X concurrentemente
        taskExecutor.afterPropertiesSet();
        return taskExecutor;
    }

}
