package tej.spring.restcrud.DemoSpringBootRestOperations.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import tej.spring.restcrud.DemoSpringBootRestOperations.model.Product;
import tej.spring.restcrud.DemoSpringBootRestOperations.service.ProductService;

import java.util.Arrays;
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
    public Product getProduct(@PathVariable("pId") String id) {
        return productService.getProduct(id);
    }
}
