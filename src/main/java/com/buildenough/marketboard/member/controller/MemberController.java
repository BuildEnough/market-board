package com.buildenough.marketboard.member.controller;

import com.buildenough.marketboard.member.dto.LoginMemberDto;
import com.buildenough.marketboard.member.dto.MemberJoinDto;
import com.buildenough.marketboard.member.dto.MemberLoginDto;
import com.buildenough.marketboard.member.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/")
    public String home(HttpSession session, Model model) {
        LoginMemberDto loginMember = (LoginMemberDto) session.getAttribute("loginMember"); // 세션에서 로그인 정보를 꺼냄, 반환타입 Object라서 변환
        model.addAttribute("loginMember", loginMember);
        return "home";
    }

    @GetMapping("/members/join")
    public String joinForm() {

        return "member/join";
    }

    @PostMapping("/members/join")
    public String join(MemberJoinDto memberJoinDto) {
        memberService.join(memberJoinDto);
        return "redirect:/";
    }

    @GetMapping("/members/login")
    public String loginForm() {
        return "member/login";
    }

    @PostMapping("/members/login")
    public String login(MemberLoginDto memberLoginDto, HttpSession session, Model model) {
        LoginMemberDto loginMember = memberService.login(memberLoginDto);

        if (loginMember == null) {
            model.addAttribute("loginError", "아이디 또는 비밀번호가 일치하지 않습니다.");
            return "member/login";
        }

        session.setAttribute("loginMember", loginMember); // 로그인 성공 시
        return "redirect:/";
    }

    @PostMapping("/members/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // 현재 세션 삭제
        return "redirect:/";
    }
}
