package com.sap.productcatalogue.repository;

import com.sap.productcatalogue.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

     @Query("select p from Product p join fetch p.color join fetch p.brand where p.colorId= :colorId")
     List<Product> findByColorId(@Param(value = "colorId")Integer colorId);

//     @Query("select p from Product p join p.color join p.brand where p.brandId=:brandId")
//     List<Product> findByBrandId(@Param(value = "brandId")Integer brandId);

     List<Product> findBySize(String size);
}
