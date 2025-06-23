package com.ecommerce.ecommerce.springproject.dao;

import com.ecommerce.ecommerce.springproject.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "product", path="product")
public interface ProductRepository extends JpaRepository<Product,Long> { // here Long means the datatype of Primary
    // key of  product is Long
}
