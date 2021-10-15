package br.com.giovanni.testthreads.threads;

import java.util.List;

public class PrintNumbersMultiplyingThread extends Thread {

    private final List<Long> numbers;

    public PrintNumbersMultiplyingThread(final List<Long> numbers) {
        this.numbers = numbers;
        setName("PrintNumbersMultiplyingThread");
    }

    @Override
    public void run() {
        this.numbers.forEach(number -> {
            try {
                sleep(number * 100);
                //Exception pode acontecer quando uma Thread é interrompida durante o periodo em que esta esperando(waiting)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(getName() + " - Number: " + number * 100);
        });
    }
}
