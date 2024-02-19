package com.codingrecipe.board.controller;

import com.codingrecipe.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService; //주입 받고자하는 클래스

    @GetMapping("/save")
    public String save(){
        return "save";
    }
}
