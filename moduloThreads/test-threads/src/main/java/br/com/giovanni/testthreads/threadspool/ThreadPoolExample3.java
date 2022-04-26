package br.com.giovanni.testthreads.threadspool;

import java.util.concurrent.*;

public class ThreadPoolExample3 {

    /*
     * ThreadPoolExecutor
     * Vamos conhecer agora uma implementação diferente de ThreadPool que nos fornece um controle maior do nosso
     * o que pode facilitar bastante caso precisemos tunnar a performace de nossa aplicação
     * Podemos alterar alguns parametros como
     * -corePoolSize
     * -maximunPoolSize
     * -keepAliveTime*/

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        executor.setKeepAliveTime(5, TimeUnit.SECONDS);
        executor.setCorePoolSize(1);//permanecer pelo menos 1 thread sendo ativa

        executor.submit(() -> {
            System.out.println(Thread.currentThread().getName() + " sendo executada");
            Thread.sleep(2000);
            return null;
        });
        System.out.println("Numero de Threads atual " + executor.getActiveCount());

        executor.submit(() -> {
            System.out.println(Thread.currentThread().getName() + " sendo executada");
            Thread.sleep(2000);
            return null;
        });
        System.out.println("Numero de Threads atual " + executor.getActiveCount());

        executor.submit(() -> {
            System.out.println(Thread.currentThread().getName() + " sendo executada");
            Thread.sleep(2000);
            return null;
        });
        System.out.println("Numero de Threads atual " + executor.getActiveCount());

        executor.submit(() -> {
            System.out.println(Thread.currentThread().getName() + " sendo executada");
            Thread.sleep(2000);
            return null;
        });
        System.out.println("Numero de Threads atual " + executor.getActiveCount());
        executor.getActiveCount();

        Thread.sleep(5000);

        System.out.println("Numero de Threads atual " + executor.getActiveCount());

    }
}
