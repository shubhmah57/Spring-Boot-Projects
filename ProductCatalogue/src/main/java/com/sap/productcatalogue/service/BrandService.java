package com.sap.productcatalogue.service;

import com.sap.productcatalogue.entity.Product;

import java.util.List;

public interface BrandService {

    public List<Product> findProductByBrand(Integer id);
}
