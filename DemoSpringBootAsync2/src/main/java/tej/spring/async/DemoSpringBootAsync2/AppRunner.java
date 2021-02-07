package tej.spring.async.DemoSpringBootAsync2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class AppRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(AppRunner.class);
    private final LookUpService lookUpService;

    public AppRunner(LookUpService lookUpService) {
        this.lookUpService = lookUpService;
    }

    @Override
    public void run(String... args) throws Exception {
        long start = System.currentTimeMillis();
        CompletableFuture<Greeting> result = lookUpService.findGreeting();
        CompletableFuture.allOf(result).join();
        logger.info("Elapsed time: " + (System.currentTimeMillis() - start));
        logger.info("--> " + result.get());
    }
}
