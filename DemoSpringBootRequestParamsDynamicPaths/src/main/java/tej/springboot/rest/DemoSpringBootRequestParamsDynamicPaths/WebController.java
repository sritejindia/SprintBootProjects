package tej.springboot.rest.DemoSpringBootRequestParamsDynamicPaths;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/org2/")
public class WebController {

    @GetMapping("/")
    public String formPage() {
        return "editName";
    }
    
    @ResponseBody
    @GetMapping("/info")
    public String myName(@RequestParam(defaultValue = "Skillsoft") String name) {
        return "<h2>Welcome to Spring boot at <i>" + name + "</i>! This is an second version HTTP GET request </h2>";
    }
}
