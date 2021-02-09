package tej.spring.restcrud.DemoSpringBootRestOperations.service;

import org.springframework.stereotype.Service;
import tej.spring.restcrud.DemoSpringBootRestOperations.model.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    private List<Product> products = new ArrayList<>(Arrays.asList(
            new Product("P101","Monitor","Electronics"),
            new Product("P102","Blanket","Household"),
            new Product("P103","Laptop","Electronics"),
            new Product("P104","Shirt","Fashion"),
            new Product("P105","Pens","School")
    ));

    public List<Product> getAllProducts() {
        return products;
    }

    public Product getProduct(String id) {
        return products.stream().filter(product -> product.getId().equals(id)).findFirst().get();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

}
