package tej.springboot.email.DemoSpringBootEmail.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;

@Configuration
public class MailController implements CommandLineRunner {

    @Autowired
    private JavaMailSender javaMailSender;


    @Override
    public void run(String... args) throws MessagingException, IOException {
        System.out.println("Sending mail.........");
        //sendEmail();
        sendEmailWithAttachment();
        System.out.println("Mail sent.");
    }

    private void sendEmailWithAttachment() throws MessagingException {
        MimeMessage mimeMsg = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMsg,true);
        mimeMessageHelper.setTo("sritejindia@gmail.com");
        mimeMessageHelper.setSubject("Email sent using SpringBoot - Attachment added");
        mimeMessageHelper.setText("Hello! \n \n Welcome to <h3>Spring Boot</h3>, easy to send email with attachment wasn't it?");
        mimeMessageHelper.addAttachment("sirf-mia.png",new ClassPathResource("mia.png"));
        javaMailSender.send(mimeMsg);
    }

    private void sendEmail() {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo("sritejindia@gmail.com");
        mailMessage.setSubject("Email sent using SpringBoot");
        mailMessage.setText("Hello! \n \n Welcome to Spring Boot, easy to send email wasn't it?");
        javaMailSender.send(mailMessage);
    }
}
