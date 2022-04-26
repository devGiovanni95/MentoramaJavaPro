package br.com.giovanni.testthreads.threads;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Example2 {

    /*
     * Executando 2 Trheads paralelamente
     * Neste exemplo teremos uma lista de numeros e teremos duas threads iterando sobre elas
     * enquanto uma apenas printa o numero, a outra vai printar o resultado da multiplicação por 100*/
    public static void main(String[] args) {
        final List<Long> numbers = getNumbers();
        //Thread 1
        createThread("Thread 1", () -> {
            numbers.forEach(number -> {
                threadSleep(number * 100);
                System.out.println(Thread.currentThread().getName() + " - Number: " + number);
            });
        });

        //Thread 2
        createThread("Thread 2", () -> {
            numbers.forEach(number -> {
                threadSleep(number * 100);
                System.out.println(Thread.currentThread().getName() + " - Number: " + number * 100);
            });
        });

    }

    private static void threadSleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    private static List<Long> getNumbers(){
        return LongStream.rangeClosed(1,10)
                .boxed().collect(Collectors.toList());
    }

    private static void createThread(String threadName, Runnable runnable){
        final Thread thread = new Thread(runnable);
        thread.setName(threadName);
        thread.start();
    }
}
