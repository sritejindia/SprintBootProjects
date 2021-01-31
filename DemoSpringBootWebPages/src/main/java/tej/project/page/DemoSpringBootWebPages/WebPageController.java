package tej.project.page.DemoSpringBootWebPages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebPageController {

    @Autowired
    private MessageProperties properties;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/nextpage")
    public String nextPage() {
        return "nextpage";
    }

    @GetMapping("/properties")
    public String properties() {
        return "properties";
    }


    @GetMapping("/greeting")
    public String greeting(@RequestParam String name, Model model) {

        String message = properties.getGreeting() + name;
        model.addAttribute("greetingMessage",message);
        return "greeting";
    }
}
