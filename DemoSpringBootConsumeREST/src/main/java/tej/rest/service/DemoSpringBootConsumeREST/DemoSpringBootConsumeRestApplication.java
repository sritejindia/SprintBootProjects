package tej.rest.service.DemoSpringBootConsumeREST;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class DemoSpringBootConsumeRestApplication {

	private static final Logger log = LoggerFactory.getLogger(DemoSpringBootConsumeRestApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringBootConsumeRestApplication.class, args).close();
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			Greeting greeting = restTemplate.getForObject("http://localhost:8080/greeting", Greeting.class);
			log.info(greeting.toString());
		};
	}

}
