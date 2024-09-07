package com.geppetto.hara.pinocchio.controller;

import com.geppetto.hara.pinocchio.dto.MemberDTO;
import com.geppetto.hara.pinocchio.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.SimpleTimeZone;

@Controller
@RequiredArgsConstructor // 필드를 매개 변수로 하는 컨트롤러 생성자를 자동 생성
public class MemberController {
  // 생성자 주입 @RequiredArgsConstructor
  private final MemberService memberService;

  @GetMapping("/pinocchio/home")
  public String homeForm() {
    return "/home/home";
  }

  @GetMapping("/pinocchio/yachtdice")
  public String yachtdiceForm() {
    return "/yachtdice/yachtdice";
  }

  @GetMapping("/pinocchio/wordle")
  public String wordleForm() {
    return "/wordle/wordle";
  }

  @GetMapping("/pinocchio/beatgame")
  public String beatgameForm() {
    return "/beatgame/beatgame";
  }

  @GetMapping("/pinocchio/board")
  public String boardForm() {
    return "/board/board";
  }

  // 회원가입 페이지 출력 요청
  @GetMapping("/pinocchio/save")
  public String saveForm() {
    return "/member/save";
  }

  @PostMapping("/pinocchio/save")
  public String save(@ModelAttribute MemberDTO memberDTO) {
    System.out.println("MemberController.save");
    System.out.println("memberDTO = " + memberDTO);
    memberService.save(memberDTO);
    return "/member/save";
  }

  @GetMapping("/pinocchio/signin")
  public String signinForm() {
    return "/member/signin";
  }

  @PostMapping("/pinocchio/signin")
  public String signin(@ModelAttribute MemberDTO memberDTO, HttpSession session) {
    MemberDTO signinResult = memberService.signin(memberDTO);
    if(signinResult != null) {
      // 로그인 성공
      session.setAttribute("signinEmail", signinResult.getMemberEmail());
      return "/home/home";
    } else {
      // 로그인 실패
      return "/member/signin";
    }
  }

  @GetMapping("/pinocchio/")
  public String findAll(Model model) {
    List<MemberDTO> memberDTOList = memberService.findAll();
    // html로 가져갈 데이터가 있다면 model 사용
    model.addAttribute("memberList", memberDTOList);
    return "/member/list";
  }

  @GetMapping("/pinocchio/{id}")
  public String findById(@PathVariable Long id, Model model) {
    MemberDTO memberDTO = memberService.findById(id);
    model.addAttribute("member", memberDTO);
    return "/member/detail";
  }

  @GetMapping("/pinocchio/update")
  public String updateForm(HttpSession session, Model model) {
    String myEmail = (String) session.getAttribute("signinEmail");
    MemberDTO memberDTO = memberService.updateForm(myEmail);
    model.addAttribute("updateMember", memberDTO);
    return "/member/update";
  }

  @PostMapping("/pinocchio/update")
  public String update(@ModelAttribute MemberDTO memberDTO) {
    memberService.update(memberDTO);
    return "redirect:/pinocchio/" + memberDTO.getId();
  }

  @GetMapping("/pinocchio/delete/{id}")
  public String deleteById(@PathVariable Long id) {
    memberService.deleteById(id);
    return "redirect:/pinocchio/";
  }

  @GetMapping("/pinocchio/signout")
  public String signout(HttpSession session) {
    session.invalidate();
    return "redirect:/pinocchio";
  }

  @PostMapping("/pinocchio/email-check")
  public @ResponseBody String emailCheck(@RequestParam("memberEmail") String memberEmail) {
    System.out.println("memberEmail = " + memberEmail);
    String checkResult = memberService.emailCheck(memberEmail);
    return checkResult;
//        if(checkResult != null) {
//            return "ok";
//        } else {
//            return "no";
//        }
  }
}
