package pl.szraj.indywidualny.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/Index")
    public String home() {
        return "Index";
    }
}
