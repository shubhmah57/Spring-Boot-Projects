package com.spring.app.MultiDB.Model.Product;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "products")
@Getter
@Setter
public class Product {

    @Id
    private int id;

    private String name;

    private double price;
}
