package com.spring.app.MultiDB.Repository.product;


import com.spring.app.MultiDB.Model.Product.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Integer> {


}
