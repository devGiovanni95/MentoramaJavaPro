package br.com.giovanni.testthreads.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class Example2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //Supplier
        String result = CompletableFuture.supplyAsync(()-> Thread.currentThread().getName()).get();
        System.out.println(result);
        //Runnable
        CompletableFuture.runAsync(
                () -> System.out.println("Executando a thread " + Thread.currentThread().getName())).get();
    }
}
