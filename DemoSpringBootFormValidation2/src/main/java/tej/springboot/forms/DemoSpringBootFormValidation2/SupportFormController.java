package tej.springboot.forms.DemoSpringBootFormValidation2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
public class SupportFormController {
    @GetMapping("/support")
    public String complaintForm(Model model) {
        model.addAttribute("supportDetails",new SupportForm());

        List<String> membershipList = Arrays.asList("Platinum","Gold","Silver");
        model.addAttribute("membershipList",membershipList);

        return "support";
    }

    @PostMapping("/support")
    public String submitComplaint(@Valid @ModelAttribute("supportDetails") SupportForm supportDetails,
                                  BindingResult bindingResult, Model model) {
        List<String> membershipList = Arrays.asList("Platinum","Gold","Silver");
        model.addAttribute("membershipList",membershipList);

        if(bindingResult.hasErrors()) {
            System.err.println("Errors found!");
            return "support";
        }

        System.out.println("No errors found");
        return "submit";
    }

}
