package tej.project.page.DemoSpringBootWebPages;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebPageController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/nextpage")
    public String nextPage() {
        return "nextpage";
    }
}
