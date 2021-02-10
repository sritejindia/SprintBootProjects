package tej.springboot.db_jpa.DemoSpringBootDataAccess;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tej.springboot.db_jpa.DemoSpringBootDataAccess.model.Product;
import tej.springboot.db_jpa.DemoSpringBootDataAccess.repository.ProductRepository;

@SpringBootApplication
public class DemoSpringBootDataAccessApplication implements CommandLineRunner {

	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringBootDataAccessApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		productRepository.save(new Product("Telivision","Electronics"));
		productRepository.save(new Product("AC","Electronics"));
		productRepository.save(new Product("Sofa","Furniture"));
		productRepository.save(new Product("Cushions","Home Essentials"));
		productRepository.save(new Product("Wardrobe","Furniture"));
	}
}
