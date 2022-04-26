package br.com.giovanni.testthreads.threads;

public class Example1 {

    //apenas a Thread principal rodando
    public static void main(String[] args) {

        //Static method da class Thread
        System.out.println("Sou a thread: " + Thread.currentThread().getName());
    }
}
