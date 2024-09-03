package com.geppetto.hara.pinocchio.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class MainController {

    @GetMapping("/")
    public String moveMain() {
        return "indexPage";
    }

    @GetMapping("/home")
    public String moveHome() {
        return "/home/home";
    }

    @GetMapping("/signin")
    public String moveSignin() {
        return "/signin/signin";
    }

    @GetMapping("/yachtdice")
    public String moveYachtdice() {
        return "/yachtdice/yachtdice";
    }

    @GetMapping("/wordle")
    public String moveWordle() {
        return "/wordle/wordle";
    }

    @GetMapping("/beatgame")
    public String moveBeatgame() {
        return "/beatgame/beatgame";
    }

    @GetMapping("/board")
    public String moveBoard() {
        return "/board/board";
    }

}
