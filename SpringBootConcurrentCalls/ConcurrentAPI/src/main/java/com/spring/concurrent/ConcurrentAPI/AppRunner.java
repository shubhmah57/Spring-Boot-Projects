package com.spring.concurrent.ConcurrentAPI;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Component
public class AppRunner implements CommandLineRunner {

    private final GenerateIntegerService generateIntegerService;

    AppRunner(GenerateIntegerService generateIntegerService){
        this.generateIntegerService = generateIntegerService;
    }

    @Override
    public void run(String... args) throws Exception {
        CompletableFuture<List<Integer>> list0 = generateIntegerService.findIntegers("0");
        CompletableFuture<List<Integer>> list1 = generateIntegerService.findIntegers("1");
        CompletableFuture<List<Integer>> list2 = generateIntegerService.findIntegers("2");
        CompletableFuture<List<Integer>> list3 = generateIntegerService.findIntegers("3");

        CompletableFuture.allOf(list0,list1,list2,list3).join();
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.addAll(list1.get());
        arrayList.addAll(list2.get());
        arrayList.addAll(list3.get());
        for(Integer integrs: arrayList){
            System.out.println(integrs);
        }

    }
}
