package com.buildenough.marketboard.member.controller;

import com.buildenough.marketboard.member.dto.MemberJoinDto;
import com.buildenough.marketboard.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/members/join")
    public String joinForm() {
        return "member/join";
    }

    @PostMapping("members/join")
    public String join(MemberJoinDto memberJoinDto) {
        memberService.join(memberJoinDto);
        return "redirect:/";
    }
}
