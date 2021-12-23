package com.example.asynccontrollersdataspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

@SpringBootApplication
@ComponentScan({"com.example.asynccontrollersdataspring.repositories.UserRepository",
				"com.example.asynccontrollersdataspring.controllers.UserController",
				"com.example.asynccontrollersdataspring.services.UserService",
				"com.example.asynccontrollersdataspring.configuration",
				"com.example.asynccontrollersdataspring.exceptions",
				"com.example.asynccontrollersdataspring.models.User"})
@EnableAsync
public class AsynccontrollersdataspringApplication {

	public static void main(String[] args) {
		SpringApplication.run(AsynccontrollersdataspringApplication.class, args);
	}

//	@Bean
//	public Executor taskExecutor(){
//		return ForkJoinPool.commonPool();
//	}
//
//	@Bean
//	public Executor cachedThreadPool(){
//		return Executors.newCachedThreadPool();
//	}
//
//
//	@Bean
//	public Executor customThreadPool() {
//		return ForkJoinPool.commonPool();
//
//	}
}
