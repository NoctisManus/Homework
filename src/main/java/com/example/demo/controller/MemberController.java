package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import com.example.demo.model.service.MemberService;
import com.example.demo.model.service.AddMemberRequest;
import com.example.demo.model.service.LoginRequest;
import com.example.demo.model.domain.Member;

@Controller
public class MemberController {
	
@Autowired
private MemberService memberService;

@GetMapping("/join_new") // 회원 가입 페이지 연결
public String join_new(Model model) {
model.addAttribute("addMemberRequest", new AddMemberRequest());
return "join_new"; // .HTML 연결
}
@PostMapping("/api/members") // 회원 가입 저장
public String addmembers(@Valid @ModelAttribute AddMemberRequest request, BindingResult bindingResult, Model model) {
if (bindingResult.hasErrors()) {
return "join_new"; // 검증 실패 시 회원가입 페이지로 돌아가기
}
memberService.saveMember(request);
return "join_end"; // .HTML 연결
}
@GetMapping("/member_login") // 로그인 페이지 연결
public String member_login(Model model) {
model.addAttribute("loginRequest", new LoginRequest());
return "login"; // .HTML 연결
}
@PostMapping("/api/login_check") // 로그인(아이디, 패스워드) 체크
public String checkMembers(@Valid @ModelAttribute LoginRequest request, BindingResult bindingResult, Model model, HttpSession session) {
if (bindingResult.hasErrors()) {
return "login"; // 검증 실패 시 로그인 페이지로 돌아가기
}
try {
Member member = memberService.loginCheck(request.getEmail(), request.getPassword()); // 패스워드 반환
session.setAttribute("member", member); // 세션에 회원 정보 저장
return "redirect:/board_list"; // 로그인 성공 후 이동할 페이지
} catch (IllegalArgumentException e) {
model.addAttribute("error", e.getMessage()); // 에러 메시지 전달
return "login"; // 로그인 실패 시 로그인 페이지로 리다이렉트
}
}
@GetMapping("/logout") // 로그아웃
public String logout(HttpSession session) {
session.invalidate(); // 세션 무효화
return "redirect:/board_list"; // 게시판 목록으로 리다이렉트
}
}

