package br.com.giovanni.testthreads.threadspool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExample5 {

    /**/

    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);

        executorService.scheduleAtFixedRate(() -> {
            System.out.println("Executando a thread " + Thread.currentThread().getName());
        }, 1, 1,TimeUnit.SECONDS);
        }
}
