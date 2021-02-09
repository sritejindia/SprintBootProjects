package tej.spring.restcrud.DemoSpringBootRestOperations.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tej.spring.restcrud.DemoSpringBootRestOperations.model.Product;

import java.util.Arrays;
import java.util.List;

@RestController
public class ProductController {

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return Arrays.asList(
            new Product("P101","Monitor","Electronics"),
            new Product("P102","Blanket","Household"),
            new Product("P103","Laptop","Electronics"),
            new Product("P104","Shirt","Fashion"),
            new Product("P105","Pens","School")
        );
    }


}
