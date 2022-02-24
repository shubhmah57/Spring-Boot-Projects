package com.spring.integers.ReturningIntegers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RequestMapping("/generate")
@RestController
public class IntegerController {

    @GetMapping("/number")
    public List<Integer> generatesNumbers(@RequestParam(name="id") String id){
        System.out.println("Inside Generate Numbers");
        if(id.equals("0") ){
            return Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        }
        if(id.equals("1")){
            return Arrays.asList(11,12,13,14,15,16,17,18,19,20);
        }
        if(id.equals("2")){
            return Arrays.asList(21,22,23,24,25,26,27,28,29,30);
        }
        return Arrays.asList(31,32,33,34,35,36,37,38,39,40);
    }
}
