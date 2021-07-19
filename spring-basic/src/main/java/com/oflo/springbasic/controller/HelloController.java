package com.oflo.springbasic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "spring!!");
        return "hello"; // resources/templates 하위 파일 중 hello.html를 찾아 렌더링을 함
    }
}
