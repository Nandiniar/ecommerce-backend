package com.ecommerce.ecommerce.springproject.config;

import com.ecommerce.ecommerce.springproject.Entity.Product;
import com.ecommerce.ecommerce.springproject.Entity.Product_category;
import jakarta.persistence.EntityManager;
import jakarta.persistence.metamodel.EntityType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Configuration
public class MyDataRestConfig  implements RepositoryRestConfigurer { //here repositoryRestConfigurer means ke rest api endpoint me kaunse method ko hum able ya disable kar sakte hao
    // is repositoryRestConfigurer me  hm cors etc bhi integrate kar sakte hai

    private EntityManager entityManager; // autowire jpa entity manager
   // EntityManager: A JPA (Java Persistence API) tool to interact with the database and manage entities.

    @Autowired
    public MyDataRestConfig(EntityManager theEntityManager){
        entityManager=theEntityManager;
    }

    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config,CorsRegistry cors) {
        HttpMethod[] theUnsupportedActions={HttpMethod.PUT,HttpMethod.POST,HttpMethod.DELETE}; // meand disable http method for Put,Post,Delete


        // delete HTTP methods for Product :PUT,POST,DELETE
        config.getExposureConfiguration().forDomainType(Product.class)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
                .withCollectionExposure(((metdata, httpMethods) ->httpMethods.disable(theUnsupportedActions) ));

        // delete HTTP methods for ProductCategory:PUT,POST AND DELETE
        config.getExposureConfiguration().forDomainType(Product_category.class)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
                .withCollectionExposure(((metdata, httpMethods) ->httpMethods.disable(theUnsupportedActions) ));

        // call an internal helper method
        exposeIds(config);
    }
    private void exposeIds(RepositoryRestConfiguration config){

        //expose entity ids
        // get a list of all entity classes from entity manager
        Set<EntityType<?>>entities=entityManager.getMetamodel().getEntities();
        // create an array of the entity type
        List<Class> entityClasses=new ArrayList<>();

        // get the entity types for the entities
        for(EntityType tempEntityType:entities){
            entityClasses.add(tempEntityType.getJavaType());
        }
        // expose the entitiy ids for the array of entity/domain type
        Class[] domainType=entityClasses.toArray(new Class[0]);
        config.exposeIdsFor(domainType);
    }
}
