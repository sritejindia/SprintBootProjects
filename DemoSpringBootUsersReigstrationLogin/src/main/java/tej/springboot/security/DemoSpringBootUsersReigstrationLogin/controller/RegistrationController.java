package tej.springboot.security.DemoSpringBootUsersReigstrationLogin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import tej.springboot.security.DemoSpringBootUsersReigstrationLogin.model.User;
import tej.springboot.security.DemoSpringBootUsersReigstrationLogin.service.EmailService;
import tej.springboot.security.DemoSpringBootUsersReigstrationLogin.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Map;
import java.util.UUID;

@Controller
public class RegistrationController {

    private static final Logger logger = LoggerFactory.getLogger(RegistrationController.class);

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserService userService;

    @Autowired
    private EmailService emailService;

    @GetMapping("/register")
    public ModelAndView showRegistrationPage(ModelAndView modelAndView, User user) {
        modelAndView.addObject("user",user);
        modelAndView.setViewName("register");
        return modelAndView;
    }


    @PostMapping("/register")
    public ModelAndView processRegistrationForm(ModelAndView modelAndView,
                                                @Valid User user,
                                                BindingResult bindingResult,
                                                HttpServletRequest request) {
        User userExists = userService.findByEmail(user.getEmail());

        System.out.println(userExists);

        if(userExists != null) {
            modelAndView.addObject("alreadyRegisteredMessage","Oops! There is already a " +
                    "user registered with the email provided");
            modelAndView.setViewName("register");
            bindingResult.reject("email");
        }

        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("register");
        } else {
            user.setEnabled(false);
            user.setConfirmationToken(UUID.randomUUID().toString());

            userService.saveUser(user);

            String appUrl = request.getScheme() + "://" + request.getServerName() + ":8080";

            String message = "To set your password, please click on the link below: \n" +
                    appUrl + "/confirm?token="+user.getConfirmationToken();
            emailService.sendEmail(user.getEmail(), "Please set a password", message);

            modelAndView.addObject("confirmationMessage", "A password set e-mail has been sent to "
            + user.getEmail());
            modelAndView.setViewName("register");
        }

        return modelAndView;
    }

    @GetMapping("/confirm")
    public ModelAndView confirmRegistration(ModelAndView modelAndView,
                                            @RequestParam("token")String token) {
        User user = userService.findByConfirmationToken(token);
        if(user == null) {
            modelAndView.addObject("invalidToken","Invalid Confirmation Link");
        } else {
            modelAndView.addObject("confirmationToken",user.getConfirmationToken());
        }
        modelAndView.setViewName("confirm");
        return modelAndView;
    }

    @PostMapping("/confirm")
    public ModelAndView confirmRegistration(ModelAndView modelAndView,
                                            BindingResult bindingResult,
                                            @RequestParam Map<String, String> requestParams,
                                            RedirectAttributes redir) {

        logger.info("Token received");
        User user = userService.findByConfirmationToken(requestParams.get("token"));
        user.setPassword(bCryptPasswordEncoder.encode(requestParams.get("password")));
        logger.info("Password set");
        user.setEnabled(true);
        userService.saveUser(user);

        logger.info("User saved");
        modelAndView.setViewName("confirm");
        modelAndView.addObject("successMessage","Password set successfully!");

        return modelAndView;
    }

}
