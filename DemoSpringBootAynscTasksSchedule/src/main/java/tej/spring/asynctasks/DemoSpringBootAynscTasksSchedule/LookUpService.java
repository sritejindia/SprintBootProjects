package tej.spring.asynctasks.DemoSpringBootAynscTasksSchedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
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

    @Async
    public CompletableFuture<User> findUser(String name) throws InterruptedException {
        logger.info("Looking up {}", name);
        String url = String.format("https://api.github.com/users/%s", name);
        User results = restTemplate.getForObject(url,User.class);
        Thread.sleep(4000);
        return CompletableFuture.completedFuture(results);
    }
}
