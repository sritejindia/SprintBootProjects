package tej.spring.asynctasks.DemoSpringBootAynscTasksSchedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Component
public class LookUpController {
    private static final Logger logger = LoggerFactory.getLogger(LookUpController.class);

    @Autowired
    private LookUpService lookUpService;

    private static List<String> usersList = new ArrayList<>();

    static {
        usersList.add("sritejindia");
        usersList.add("Pytorch");
        usersList.add("Tensorflow");
        usersList.add("spring-boot");
        usersList.add("spring-mvc");
        usersList.add("Scikit-learn");
    }

    private int userIndex=0;

    @Scheduled(fixedRate = 2500)
    public void scheduledTasks() throws InterruptedException, ExecutionException {
        CompletableFuture<User> info = lookUpService.findUser(usersList.get(userIndex));
        userIndex = (userIndex+1) % usersList.size();
        logger.info("---> {}", info.get().getAvatarUrl());
    }
}
