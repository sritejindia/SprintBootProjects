package tej.spring.tasks.DemoSpringBootSchedulingTasks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DemoSpringBootSchedulingTasksApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringBootSchedulingTasksApplication.class, args);
	}

}
