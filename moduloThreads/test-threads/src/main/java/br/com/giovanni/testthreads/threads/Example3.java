package br.com.giovanni.testthreads.threads;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Example3 {

    public static void main(String[] args) throws InterruptedException {
        final List<Long> numbers = getNumbers();

        final PrintNumbersThread printNumberThread = new PrintNumbersThread(numbers);
        printNumberThread.start();
        //printNumberThread.join();//com o join a thread espera ela terminar para depois executar qualquer outra para continuar

        new PrintNumbersMultiplyingThread(numbers)
                .start();
    }

    private static List<Long> getNumbers(){
        return LongStream.rangeClosed(1,10)
                .boxed().collect(Collectors.toList());
    }
}
