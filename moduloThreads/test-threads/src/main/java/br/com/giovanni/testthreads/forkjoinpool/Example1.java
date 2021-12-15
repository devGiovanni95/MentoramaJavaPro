package br.com.giovanni.testthreads.forkjoinpool;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;


public class Example1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        //Quantos cores ser'ao utilizados pelo pool?
        System.out.println("Números de cores considerados " + commonPool.getParallelism());

        CompletableFuture.allOf(
                execute(commonPool, 1),
                execute(commonPool, 2),
                execute(commonPool, 3)
        ).get();
    }

    private static CompletableFuture<Void> execute(ForkJoinPool commonPool, final int executionNumber) throws InterruptedException, ExecutionException {
        return CompletableFuture.runAsync(() -> {
            double sum = 0.0;
            for (float i = 0; i < 100; i++) {
                wait1second();
                System.out.println("Execution: " + executionNumber + " in Thread " + Thread.currentThread().getName());
                sum += i * ((i + 1) / Integer.MAX_VALUE);
            }
            System.out.println("Result is " + sum);
        }, commonPool);
    }

    private static void wait1second() {
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
