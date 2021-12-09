package br.com.giovanni.testthreads.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class Example1 {

    /*
    Vamos começar com um exemplo utilizando o CompletableFuture como se fosse um simples Future
    */

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(()-> completableFuture.complete("Executei!!"));
        //Aqui acontece o bloqueio da thread para esperar o resultado
        String result = completableFuture.get();
        System.out.println(result);
    }

}