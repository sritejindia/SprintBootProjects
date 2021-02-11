package tej.springboot.db_jpa.DemoSpringBootDataAccess.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import tej.springboot.db_jpa.DemoSpringBootDataAccess.model.Product;
import tej.springboot.db_jpa.DemoSpringBootDataAccess.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Cacheable("products")
    public List<Product> getAllProducts() {

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add);
        return products;
    }

    @Cacheable(value = "product", key = "#p0")
    public Optional<Product> getProduct(Long id) {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return productRepository.findById(id);
    }

    @CacheEvict(value = "products", allEntries = true)
    public void addProduct(Product product) {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        productRepository.save(product);
    }


    @Caching(evict = {
            @CacheEvict(value = "product", key = "#p0"),
            @CacheEvict(value = "products", allEntries = true)
    })
    public void updateProduct(Long id, Product product) {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(productRepository.findById(id).get() != null) {
            productRepository.save(product);
        }
    }

    @Caching(evict = {
            @CacheEvict(value = "product", key = "#p0"),
            @CacheEvict(value = "products", allEntries = true)
    })
    public void deleteProduct(Long id) {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        productRepository.deleteById(id);
    }

}
