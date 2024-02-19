package com.codingrecipe.board.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/") //시작페이지
    public String index(){
        System.out.println("HomeController.index");
        return "index"; //index.html을 띄우겠다는 의미
    }
}
