package com.example.async.services;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.example.async.models.GithubUser;

@Service
public class GithubLookupService {
    private static final Logger logger = LoggerFactory.getLogger(GithubLookupService.class);

    private final RestTemplate restTemplate;

    public GithubLookupService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    } 

    @Async
    public CompletableFuture<GithubUser> findUser(String query) throws InterruptedException{
        logger.info("looking for:" + query);
        String url = String.format("https://api.github.com/users/%s", query);
        GithubUser result = null;

        try{
            Thread.sleep(1000L);
            result = restTemplate.getForObject(url, GithubUser.class);
        } catch (HttpClientErrorException e){
            logger.error(e.getMessage() +" - " + e.getStatusCode(), e);
        }
        return CompletableFuture.completedFuture(result);
        
    }
 
}
