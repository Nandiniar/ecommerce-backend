package com.ecommerce.ecommerce.springproject.dao;


import com.ecommerce.ecommerce.springproject.Entity.Product_category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "productCategory", path="product-category")   // RepositoryRestResource automatically rest api endpoint banate hai controller ke bina
// here collectionResourceRel means the  name of json and path(product-category iss way me use hoge like ab hume get/product-category ya post ya put nhi banane padhege wo ab  RepositoryRestResource ke help se khud ho jayega

public interface ProductCategoryRepository extends JpaRepository<Product_category,Long> {


}

