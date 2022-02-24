package com.sap.productcatalogue.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "TBL_BRND")
@Setter
@Getter
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @JsonIgnoreProperties("brand")
    @OneToMany(mappedBy= "brand",fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
    private List<Product> products= new ArrayList<>();
}