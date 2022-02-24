package com.sap.productcatalogue.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "TBL_COLOR")
public class Color {

    @Id
    private Integer id;

    private String color;

    @OneToMany(mappedBy = "color",fetch =FetchType.LAZY)
    private Set<Product> products;

}
