package tej.spring.restcrud.DemoSpringBootRestOperations.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tej.spring.restcrud.DemoSpringBootRestOperations.model.Product;
import tej.spring.restcrud.DemoSpringBootRestOperations.service.ProductService;

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

    @PostMapping("/products")
    public void addProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }

    @PutMapping("/products/{pId}")
    public void updateProduct(@RequestBody Product product, @PathVariable("pId") String id) {
        productService.updateProduct(id, product);
    }

    @DeleteMapping("/products/{pId}")
    public void deleteProduct(@PathVariable("pId") String id) {
        productService.deleteProduct(id);
    }
}
