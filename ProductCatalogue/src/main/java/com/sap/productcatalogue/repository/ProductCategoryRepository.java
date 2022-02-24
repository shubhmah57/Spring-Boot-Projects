package com.sap.productcatalogue.repository;

import com.sap.productcatalogue.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {
}
