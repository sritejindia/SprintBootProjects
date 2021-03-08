package com.product.data.DemoProductDataService.repository;

import com.product.data.DemoProductDataService.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product,Long> {


}
