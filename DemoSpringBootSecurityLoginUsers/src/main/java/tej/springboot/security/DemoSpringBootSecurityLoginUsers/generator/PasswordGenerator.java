package tej.springboot.security.DemoSpringBootSecurityLoginUsers.generator;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {

    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String userPassword = "jdhgjfghjfd43";
        String encodedUserPassword = encoder.encode(userPassword);

        System.out.println("User password is: " + userPassword);

        String adminPassword = "dshfrgjrh454cf";
        String encodedAdminPassword = encoder.encode(adminPassword);

        System.out.println("Admin password is: " + encodedAdminPassword);

    }

}
