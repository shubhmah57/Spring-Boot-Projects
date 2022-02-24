package com.sap.productcatalogue.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "TBL_PRDT_CTG")
@Getter
@Setter
public class ProductCategory {

    @Id
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "productCategory",fetch=FetchType.LAZY)
    private Set<Product> products;


}
