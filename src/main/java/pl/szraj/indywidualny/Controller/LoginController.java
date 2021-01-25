package pl.szraj.indywidualny.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.szraj.indywidualny.Entity.User;
import pl.szraj.indywidualny.Service.UserService;

@Controller
public class LoginController {
    UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "/Security/Login";
    }

    @GetMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "/Security/Login";
    }

    @GetMapping("/signUp")
    public String signUp(Model model) {
        model.addAttribute("user", new User());
        return "/Security/SignUp";
    }

    @PostMapping("/signUp")
    public String signUp(@ModelAttribute("user") User user) {
        if (userService.findUserByLogin(user.getLogin()) == null) {
            user.setRole("user");
            user.setHaslo(passwordEncoder().encode(user.getHaslo()));
            userService.saveUser(user);
            return "Index";
        } else
            return "/Security/SignUp";
    }

    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
