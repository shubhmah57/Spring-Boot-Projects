package com.sap.productcatalogue.service;

import com.sap.productcatalogue.entity.Brand;
import com.sap.productcatalogue.entity.Product;
import com.sap.productcatalogue.repository.BrandRepository;
import com.sap.productcatalogue.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;

    @Autowired
    BrandRepository brandRepository;


    @Override
    public void addProduct() {

        List<Product> productList = new ArrayList<>();

        Brand brand = new Brand();
        brand.setName("ADIDAS");

        Product product = new Product();
        product.setName("BLUE WASHED JACKET");
        product.setQuantity(1);
        product.setSize("L");
        product.setPrice(2000);

        productList.add(product);

        product.setBrand(brand);

        brand.setProducts(productList);


        brandRepository.save(brand);


    }
}
