package com.ecommerce.ecommerce.springproject.config;

import com.ecommerce.ecommerce.springproject.Entity.Product;
import com.ecommerce.ecommerce.springproject.Entity.Product_category;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class MyDataRestConfig  implements RepositoryRestConfigurer { //here repositoryRestConfigurer means ke rest api endpoint me kaunse method ko hum able ya disable kar sakte hao
    // is repositoryRestConfigurer me  hm cors etc bhi integrate kar sakte hai


    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        HttpMethod[] theUnsupportedActions={HttpMethod.PUT,HttpMethod.POST,HttpMethod.DELETE}; // meand disable http method for Put,Post,Delete


        // delete HTTP methods for Product :PUT,POST,DELETE
        config.getExposureConfiguration().forDomainType(Product.class)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
                .withCollectionExposure(((metdata, httpMethods) ->httpMethods.disable(theUnsupportedActions) ));

        // delete HTTP methods for ProductCategory:PUT,POST AND DELETE
        config.getExposureConfiguration().forDomainType(Product_category.class)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
                .withCollectionExposure(((metdata, httpMethods) ->httpMethods.disable(theUnsupportedActions) ));

    }
}
