package com.sap.productcatalogue.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "TBL_PRDCT")
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private Integer quantity;

    private String size;

    private Integer price;


    @Column(name= "COLOR_ID")
    private Integer colorId;

    @Column(name = "PRDT_CTG_ID")
    private Integer productCategoryId;

    @JsonIgnoreProperties("products")
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinColumn(name = "BRND_ID", referencedColumnName = "id")
    private Brand brand;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(insertable = false, updatable = false, name ="COLOR_ID")
    private Color color;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(insertable = false, updatable = false,name = "PRDT_CTG_ID")
    private ProductCategory productCategory;

}
