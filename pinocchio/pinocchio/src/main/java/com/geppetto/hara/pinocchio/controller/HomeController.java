package com.geppetto.hara.pinocchio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
  // 기본 페이지 요청 메서드
  @GetMapping("/pinocchio")
  public String index() {
    return "index"; // templates 폴더의 index.html을 찾아감
  }
}
