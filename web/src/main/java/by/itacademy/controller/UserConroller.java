package by.itacademy.controller;

import by.itacademy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserConroller {

    private final UserService userService;

    @Autowired
    public UserConroller(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/")
    public String startPage(){
        return "index";
    }

//    @PostMapping(path = "/user")
//    public String getUser(@RequestParam Long id, Model model){
//        User user = userService.getById(id);
//        model.addAttribute(user);
//        return "user";
//    }
}
