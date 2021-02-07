package tej.spring.async.DemoSpringBootAsync2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
public class LookUpService {
    private static final Logger logger = LoggerFactory.getLogger(LookUpService.class);
    private final RestTemplate restTemplate;

    public LookUpService(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    public CompletableFuture<Greeting> findGreeting() throws InterruptedException {
        logger.info("Looking up the greeting");
        String url = "http://localhost:8080/greeting";
        Greeting result = restTemplate.getForObject(url, Greeting.class);
        Thread.sleep(1000L);
        return CompletableFuture.completedFuture(result);
    }
}
