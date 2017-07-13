package by.itacademy.controller;

import by.itacademy.entity.Topic;
import by.itacademy.entity.User;
import by.itacademy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

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

    @GetMapping(path = "/user")
    public String getUser(Model model){
        User user = userService.getByLogin(SecurityContextHolder.getContext().getAuthentication().getName());
        List<Topic> topics = userService.getCreatedTopicsById(user.getId());
        model.addAttribute("user", user);
        model.addAttribute("topics", topics);
        return "user";
    }
}
