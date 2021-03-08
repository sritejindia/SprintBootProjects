package com.product.data.DemoProductDataService;

import com.product.data.DemoProductDataService.model.Product;
import com.product.data.DemoProductDataService.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoProductDataServiceApplication implements CommandLineRunner {

	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoProductDataServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		productRepository.save(new Product("Apple Macbook Pro", "Laptop",
				"https://media.croma.com/image/upload/f_auto,q_auto,d_Croma%20Assets:no-product-image.jpg,h_256,w_256/v1605340828/Croma%20Assets/Entertainment/Television/Images/8942605139998.png"));
	}
}
