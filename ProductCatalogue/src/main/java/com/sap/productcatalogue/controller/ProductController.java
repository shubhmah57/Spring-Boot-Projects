package com.sap.productcatalogue.controller;

import com.sap.productcatalogue.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping(path = "/add" , method = RequestMethod.POST)
    public void addProducts(){
        productService.addProduct();
        System.out.println("Completed..");
    }
}
