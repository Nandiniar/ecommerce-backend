package com.ecommerce.ecommerce.springproject.dao;

import com.ecommerce.ecommerce.springproject.Entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "product", path="product")
public interface ProductRepository extends JpaRepository<Product,Long> { // here Long means the datatype of Primary
    // key of  product is Long


    // here findbyCategoryId is a query method which work similar to select * from product where id=? and in our page function
    // id will be used as a parameter value
    Page<Product>findByCategoryId(@Param("id") Long id, Pageable pageable);
    // this line will  work similar  to select * from product where category_id=?

    // page and pagable provides support for pagination
    //page is a sublist of a list of objects and has information such as totalElements,totalPages,Currentposition etc
    // pageable represent pagination information such as page number, page size,previous,next etc
    // query method starts by findby,searchby and its endpoints are /search/<<queryMethodName
}
