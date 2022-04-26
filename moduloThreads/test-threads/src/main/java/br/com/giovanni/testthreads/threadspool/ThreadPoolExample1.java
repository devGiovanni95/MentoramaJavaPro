package br.com.giovanni.testthreads.threadspool;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ThreadPoolExample1 {

    /*Submeter tasks para um executor com um pool de threads especifico*/

    public static void main(String[] args) {
        Executor executor = Executors.newFixedThreadPool(2);

        executor.execute(()->
                System.out.println(Thread.currentThread().getName() + " - Executor service me executou"));

        executor.execute(()->
                System.out.println(Thread.currentThread().getName() + " - Executor service me executou"));

        executor.execute(()->
                System.out.println(Thread.currentThread().getName() + " - Executor service me executou"));
    }
}
