package br.com.giovanni.testthreads.completablefuture;

import ch.qos.logback.core.boolex.EvaluationException;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Example5 {

    /*
    Quando estamos trabalhando com CompletableFuture, a maneira como lidamos com exceptions é um pouco diferente
    ao inve de usar blocos de try/catch utilizaremos um método handle especial
    */
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //No examplo abaixo nós determinamos um valor 0.0 como em caso de exception
        final Double number = 2.0;
        CompletableFuture<Double> completableFuture = CompletableFuture.supplyAsync(() -> 150.0 / number)
                .handle((value, throwable) -> throwable == null ? value : 0.0);

        Double result = completableFuture.get();
        System.out.println("O resultado da divisão deu " + result);

        //No examplo abaixo nós determinamos um valor 0.0 como em caso de exception
        final Double number1 = null;
        CompletableFuture<Double> completableFuture0 = CompletableFuture.supplyAsync(() -> 150.0 / number1)
                //Outro modo de fazer utilizando o if()
                .handle((value, throwable) -> {
                    if (throwable == null) {
                        return value;
                    }
                    throwable.printStackTrace();
                    return 0.0;
    });

    Double result1 = completableFuture0.get();
        System.out.println("O resultado da divisão deu " + result1);

    //Já no exemplo abaixo, nós queremos encerrar a execução com uma exception ao invés de um valor padrão
    CompletableFuture<String> completableFuture1 = new CompletableFuture<>();
        completableFuture1.completeExceptionally(new

    RuntimeException("Deu ruim...."));
        completableFuture1.get();


}
}
