package by.itacademy.controller;

import by.itacademy.entity.RoleOfUser;
import by.itacademy.entity.User;
import by.itacademy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserConroller {

    private final UserService userService;

    @Autowired
    public UserConroller(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/user")
    public String startPage(){
        return "start-form";
    }

    @PostMapping(path = "/user")
    public String getUser(@RequestParam Long id, Model model){
        User user = userService.getById(id);
        List<RoleOfUser> rolles = userService.getAllRolles(id);
        model.addAttribute(user);
        model.addAttribute(rolles);
        return "user";
    }
}
