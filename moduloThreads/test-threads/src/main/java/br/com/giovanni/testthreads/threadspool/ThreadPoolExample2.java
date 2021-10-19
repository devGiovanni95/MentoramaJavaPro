package br.com.giovanni.testthreads.threadspool;

import java.util.concurrent.*;

public class ThreadPoolExample2 {

    /*ExecutionException pode ocorrer ao tentar recuperar o resultado de uma task que foi abordada
    * InterruptedException já conhecemos no contexto de threads*/

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        for (int i = 0; i < 10; i++){
            Future<String> future = executorService.submit(()-> "A thread " + Thread.currentThread().getName() + " me executou");

            String resultado = future.get();
            System.out.println(resultado + "interacao" + i);
        }
    }
}
