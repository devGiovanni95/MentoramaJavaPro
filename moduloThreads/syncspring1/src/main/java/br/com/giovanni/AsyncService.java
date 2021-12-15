package br.com.giovanni;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class AsyncService {

    private final FakeService fakeService;

    public AsyncService(FakeService fakeService) {
        this.fakeService = fakeService;
    }

    //somente funciona de maneira separa se estiver numa classe diferente
    @Async
    public CompletableFuture<String> findUserById(final Integer id) {
        System.out.println("Executing method in Thread " + Thread.currentThread().getName());
        return CompletableFuture.completedFuture(fakeService.findUserById(id));
    }

    /*
    * No cachedThreadPool
    *
    * Thread principal restartedMain
Executing method in Thread pool-1-thread-1
Executing method in Thread pool-1-thread-2
Executing method in Thread pool-1-thread-3
Elapsed time: 2030
--> User 1
--> User 2
--> User 3
    * */

    /*
    * No ForkJoinPool
    *
    * Thread principal restartedMain
Executing method in Thread ForkJoinPool.commonPool-worker-1
Executing method in Thread ForkJoinPool.commonPool-worker-2
Executing method in Thread ForkJoinPool.commonPool-worker-3
Elapsed time: 2069
--> User 1
--> User 2
--> User 3
    * */

    /*
    * Sem bean nenhum de configuração
    *
    * Thread principal restartedMain
Executing method in Thread task-3
Executing method in Thread task-1
Executing method in Thread task-2
Elapsed time: 2041
--> User 1
--> User 2
--> User 3
    * */
}