package com.poly.option9.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    String username = "nguyenhoangtuananh1592005@gmail.com";
    String password = "tuananh0520";

    @GetMapping("/option1")
    public String option1() {
        return "Login";
    }

    @GetMapping("/option2")
    public String option2() {
        return "Home";
    }

    @PostMapping("/option1/confirm")
    public String confirm(@RequestParam("username") String usernameString,
            @RequestParam("password") String passwordString,
            Model model) {
        if (usernameString.equals(username) && passwordString.equals(password)) {
            return "redirect:/option2";
        }
        return "redirect:/option1";
    }

}
