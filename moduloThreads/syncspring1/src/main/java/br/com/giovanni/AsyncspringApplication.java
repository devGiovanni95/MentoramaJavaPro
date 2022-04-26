package br.com.giovanni;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

@SpringBootApplication
//Faz com que o spring busque por annotations @Async para executar o Método em uma thread separada
@EnableAsync
public class AsyncspringApplication {

    public static void main(String[] args) {
        SpringApplication.run(AsyncspringApplication.class, args);
    }

    //Por padrão o Executor utilizado é o SimpleAsyncTaskExecutor,
    // que basicamente levanta 1 thread para executar cada camada
    @Bean
    public Executor taskExecutor(){
        return ForkJoinPool.commonPool();
    }

    @Bean
    public Executor cachedThreadPool(){
        return Executors.newCachedThreadPool();
    }


}
