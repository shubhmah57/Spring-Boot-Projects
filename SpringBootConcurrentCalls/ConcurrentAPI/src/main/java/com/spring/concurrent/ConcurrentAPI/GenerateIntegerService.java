package com.spring.concurrent.ConcurrentAPI;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class GenerateIntegerService {

    public final RestTemplate restTemplate;

    GenerateIntegerService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
    }

    @Async
    public CompletableFuture<List<Integer>> findIntegers(String id) throws InterruptedException {
        String url = String.format("http://localhost:8080/generate/number?id=%s",id);
        List<Integer> numbList= restTemplate.getForObject(url, List.class);
        //Artificial delay of 1s
        System.out.println(Thread.currentThread().getName());
        Thread.sleep(1000L);
        return CompletableFuture.completedFuture(numbList);
    }
}
