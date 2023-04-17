package com.example.async;

import java.util.concurrent.Executor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@SpringBootApplication
@EnableAsync
public class AsyncApplication {

	public static void main(String[] args) {
		SpringApplication.run(AsyncApplication.class, args);
	}

	@Bean
  	public Executor taskExecutor() {
    	ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		// if these options set to 2 it take 10 to 12 seconds (2 tasks are run meanwhile)
		// if these options set to 3 or more it take 5 to 6 seconds (all tasks are run meanwhile)
		executor.setCorePoolSize(4);
    	executor.setMaxPoolSize(4);
    	executor.setQueueCapacity(500);
    	executor.setThreadNamePrefix("GithubLookup-");
    	executor.initialize();
    	return executor;
 	}

}
