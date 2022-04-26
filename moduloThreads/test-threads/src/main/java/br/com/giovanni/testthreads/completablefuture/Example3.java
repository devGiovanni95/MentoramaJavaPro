package br.com.giovanni.testthreads.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Example3 {
    /*
    *Encadeando chamadas
    */

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture completableFuture = CompletableFuture.supplyAsync(() -> 10L)
                //Apply
                .thenApply(number -> number * 10)
                //Accept
                .thenAccept(number -> System.out.println("O número é " + number))
                //Run
                .thenRun(() -> System.out.println("Acabou o processamento"));

        completableFuture.get();
    }
}
