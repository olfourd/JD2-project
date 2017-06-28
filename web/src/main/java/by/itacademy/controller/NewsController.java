package by.itacademy.controller;

import by.itacademy.entity.News;
import by.itacademy.service.NewsService;
import by.itacademy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class NewsController {

    @Autowired
    private NewsService newsService;

    @ModelAttribute("news")
    public List<News> news(){
        return newsService.getAll();
    }
    @GetMapping("/news")
    public String getNewsPage(){
        return "news";
    }


}
