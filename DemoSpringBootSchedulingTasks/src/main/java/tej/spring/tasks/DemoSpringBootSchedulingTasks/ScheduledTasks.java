package tej.spring.tasks.DemoSpringBootSchedulingTasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduledTasks {
    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() throws InterruptedException {
        logger.info("The time is now {}",dateFormat.format(new Date()));
    }

    @Scheduled(fixedRate = 2000, initialDelay = 1000)
    public void reportWorking() {
        logger.info("This is working {}",dateFormat.format(new Date()));
    }

    @Scheduled(fixedRateString = "${scheduler.rate}")
    public void background() {
        logger.info("This is background task for fixed rate string {}", dateFormat.format(new Date()));
    }

}
