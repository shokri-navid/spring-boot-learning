package com.example.async;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.async.models.GithubUser;
import com.example.async.services.GithubLookupService;

@Component
public class AppRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(AppRunner.class);

    private final GithubLookupService lookupService; 
    public AppRunner(GithubLookupService lookupService) {
        this.lookupService = lookupService;
    }
    @Override
    public void run(String... args) throws Exception {
        Long start = System.currentTimeMillis();

        CompletableFuture<GithubUser> user1 = this.lookupService.findUser("navid-dada");
        CompletableFuture<GithubUser> user2 = this.lookupService.findUser("navid-shokri");
        CompletableFuture<GithubUser> user3 = this.lookupService.findUser("mrvahedi68");

        CompletableFuture.allOf(user1, user2, user3).join();

        logger.info("elapsed time: "+ (System.currentTimeMillis() - start));
        logger.info(" ---> "+user1.get());
        logger.info(" ---> "+user2.get());
        logger.info(" ---> "+user3.get());



    }

}
