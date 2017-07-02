package by.itacademy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GameInfoController {

    @GetMapping(path = "/gameInfo")
    public String getGameInfoPage(){
        return "game_info";
    }
}
