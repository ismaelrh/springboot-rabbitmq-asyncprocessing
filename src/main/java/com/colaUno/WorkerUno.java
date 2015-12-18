package com.colaUno;

import org.springframework.stereotype.Component;

/**
 * Worker que realiza una tarea a partir de la cola 1.
 */
@Component
public class WorkerUno implements Runnable {

    private String param;
    public void setParameter(String param){
        this.param = param;

    }

    @Override
    public void run() {
        long id =  Thread.currentThread().getId();
        System.out.println("Worker 1 - " + param + " - ID:" + id);
    }
}
