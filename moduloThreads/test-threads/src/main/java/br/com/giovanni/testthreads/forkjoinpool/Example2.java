package br.com.giovanni.testthreads.forkjoinpool;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class Example2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        final List<Double> list = Arrays.asList(10.0,50.0,100.56721,900.0,300.2);
        //Método que utiliza por padrão o ForkJoinPool.commonPool()
        list.parallelStream()
                .map(x -> x *2)
                .forEach(System.out::println);

        CompletableFuture.runAsync(() -> System.out.println("Hello World"));
        CompletableFuture.runAsync(() -> System.out.println(Thread.currentThread().getName())).get();
        CompletableFuture.runAsync(() -> System.out.println(Thread.currentThread().getName()), Executors.newCachedThreadPool()).get();
    }
}
