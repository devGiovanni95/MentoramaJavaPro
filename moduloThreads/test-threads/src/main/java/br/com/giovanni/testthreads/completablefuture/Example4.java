package br.com.giovanni.testthreads.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Example4 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*
        A idéia do compose é muito parecida com o fletMap da stream API
        a ideia é que o CompletableFuture seja resolvido e dessa maneira o valor retornado normalmente
        fazendo uma composição das execuções
        */

        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Hello")
                .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + " World"));

        System.out.println(completableFuture.get());

        /*
        No caso de precisarmos execurtar dois futures independentes e depois combinar seus resultados
        podemos utilizar o thenCombine
        */

        CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(() -> "Hello")
                .thenCombine(
                        CompletableFuture.supplyAsync(() -> " World"),
                        (s1, s2)-> s1 + s2
                );
        System.out.println(completableFuture2.get());


        /*
        *Executando multiplos futeres em paralelo
        */

        CompletableFuture cf1 =
                CompletableFuture.runAsync(() -> System.out.println("Future 1 na Thread " + Thread.currentThread().getName()));

        CompletableFuture cf2 =
                CompletableFuture.runAsync(() -> System.out.println("Future 2 na Thread " + Thread.currentThread().getName()));

        CompletableFuture cf3 =
                CompletableFuture.runAsync(() -> System.out.println("Future 3 na Thread " + Thread.currentThread().getName()));

        CompletableFuture cf4 =
                CompletableFuture.runAsync(() -> System.out.println("Future 4 na Thread " + Thread.currentThread()));

        CompletableFuture.allOf(cf1,cf2,cf3,cf4).get();
     }
}
