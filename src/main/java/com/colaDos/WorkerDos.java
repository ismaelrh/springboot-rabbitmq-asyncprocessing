package com.colaDos;

import org.springframework.stereotype.Component;

/**
 * Worker que realiza una tarea a partir de la cola 2.
 */
@Component
public class WorkerDos implements Runnable {

    private String param;
    public void setParameter(String param){
        this.param = param;

    }

    @Override
    public void run() {
        long id =  Thread.currentThread().getId();
        System.out.println("Worker 2 - " + param + " - ID:" + id);
    }
}
