package br.com.giovanni.testthreads.threadspool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExample4 {

    /*
     * Neste exemplo veremos como criar um threadpool para tarefas agendadas ou Scheduled Tasks
     * */

    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);

        executorService.schedule(() -> {
            System.out.println(Thread.currentThread().getName());
        }, 1, TimeUnit.SECONDS);

        executorService.schedule(() -> {
            System.out.println(Thread.currentThread().getName());
        }, 1, TimeUnit.SECONDS);

        executorService.schedule(() -> {
            System.out.println(Thread.currentThread().getName());
        }, 1, TimeUnit.SECONDS);

    }
}
