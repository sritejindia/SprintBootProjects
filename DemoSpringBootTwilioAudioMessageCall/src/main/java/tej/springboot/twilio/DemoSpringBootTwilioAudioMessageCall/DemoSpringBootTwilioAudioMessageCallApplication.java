package tej.springboot.twilio.DemoSpringBootTwilioAudioMessageCall;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URI;

@SpringBootApplication
public class DemoSpringBootTwilioAudioMessageCallApplication implements ApplicationRunner {

	private static final String ACCOUNT_SID="******************";
	private static final String AUTH_TOKEN="******************";
	public static final String TWILIO_NUMBER="******************";

	static {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringBootTwilioAudioMessageCallApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

		// For sending messages
	/*	Message.creator(new PhoneNumber("******************"), new PhoneNumber(TWILIO_NUMBER),
				"Welcome to my demo program").create();
		System.out.println("Sending message......!!!");*/

		// FOr calling
		Call.creator(new PhoneNumber("******************"), new PhoneNumber(TWILIO_NUMBER),
				new URI("https://demo.twilio.com/welcome/voice/voice.xml")).create();
		System.out.println("Calling.......!");
	}
}
