package com.product.data.DemoProductDataService.controller;

import com.product.data.DemoProductDataService.model.Product;
import com.product.data.DemoProductDataService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }


    @GetMapping("/products/{pId}")
    public Product getProduct(@PathVariable("pId")Long id) throws Exception {
        return productService.getProduct(id).orElseThrow(() -> new Exception());
    }


    @PostMapping("/products")
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }

}
