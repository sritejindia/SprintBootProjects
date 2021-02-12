package tej.springboot.proxy.DemoSBAPIforProxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class DemoSbapIforProxyApplication {

	@RequestMapping("/search")
	public String search() {
		return "<h3>Searching for a product.</h3>";
	}

	@RequestMapping("/order")
	public String order() {
		return "<h3>Placing a product order</h3>";
	}


	public static void main(String[] args) {
		SpringApplication.run(DemoSbapIforProxyApplication.class, args);
	}

}
