package com.ecommerce.ecommerce.springproject.Entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name="product_category")
public class Product_category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="category_name")
    private String category_name;
    @OneToMany(cascade = CascadeType.ALL,mappedBy="category") // cascade=CascadeType.ALL Means what will happen to parent , that will automatically happen to children
    private Set<Product> products;

}