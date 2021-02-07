package tej.springboot.rest.DemoSpringBootRequestParamsDynamicPaths;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/organization/")
public class WebServiceController {

    @GetMapping("/info")
    public String myName(@RequestParam(name="orgName", required = true) String name) {
        return "<h2>Welcome to Spring boot at <i>" + name + "</i>! This is an HTTP GET request </h2>";
    }

    @GetMapping("/info/{name}")
    public String myNameVersion2(@PathVariable(name="name") String name) {
        return "<h2>Welcome to Spring boot at <i>" + name + "</i>! This is an second version HTTP GET request </h2>";
    }
}
