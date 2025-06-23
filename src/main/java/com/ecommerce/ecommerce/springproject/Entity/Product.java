package com.ecommerce.ecommerce.springproject.Entity;


import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;

@Entity // @entity are used only with jpa
@Table(name="product")
@Data
public class Product {
@Id // here @Id like this means it is primary value
    @GeneratedValue(strategy = GenerationType.IDENTITY) // this means how the id will be created automatically unique for each row
    @Column(name="id")
    private Long id;



    @ManyToOne
    @JoinColumn(name="category_id",nullable=false) // this means product table will have category_id field which will have id of product here ut act as a foreign key
    private Product_category category;

    @Column(name="sku")
    private String sku;
    @Column(name="name")
    private String name;
    @Column(name="description")
    private String description;
    @Column(name="unit_price")
    private BigDecimal unit_price;
    @Column(name="image_url")
    private String image_url;
    @Column(name="active")
    private boolean active;
    @Column(name="units_in_stock")
    private int  units_in_stock;
    @Column(name="date_created")
    @CreationTimestamp // it automatically set the time and date when the record is created it is used in hibernation
    private Date date_created;
    @Column(name="last_updated")
    @UpdateTimestamp // it automatically update the time and date whenever a record is modified it is used in hibernation
    private Date last_updated;



}
