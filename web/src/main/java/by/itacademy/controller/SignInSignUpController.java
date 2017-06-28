package by.itacademy.controller;

import by.itacademy.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class SignInSignUpController {

    @ModelAttribute("user")
    public User user(){
        return new User();
    }

    @GetMapping(path = "/signin")
    public String getSignInPage(){
        return "signin";
    }

    @GetMapping(path = "/signup")
    public String getSignUpPage(){
        return "signup";
    }

    @PostMapping("/signup")
    public String saveUser(@RequestBody User user){
        System.out.println(user);
        return "signup";
    }

}
