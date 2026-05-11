package com.buildenough.marketboard.post.controller;

import com.buildenough.marketboard.member.dto.LoginMemberDto;
import com.buildenough.marketboard.post.dto.PostWriteDto;
import com.buildenough.marketboard.post.service.PostService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/posts/write")
    public String writeForm(HttpSession session) {
        LoginMemberDto loginMemberDto = (LoginMemberDto) session.getAttribute("loginMember"); // loginMember은 member의 컨트롤러에서 세팅해주었음

        if (loginMemberDto == null) {
            return "redirect:/members/login";
        }

        return "posts/write";
    }

    @PostMapping("/posts")
    public String write(PostWriteDto postWriteDto, HttpSession session) {
        LoginMemberDto loginMemberDto = (LoginMemberDto) session.getAttribute("loginMember");

        if (loginMemberDto == null) {
            return "redirect:/members/login";
        }

        postWriteDto.setMemberId(loginMemberDto.getMemberId());
        postService.writePost(postWriteDto);

        return "redirect:/";
    }


}
