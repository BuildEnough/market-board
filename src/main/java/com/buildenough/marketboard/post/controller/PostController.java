package com.buildenough.marketboard.post.controller;

import com.buildenough.marketboard.member.dto.LoginMemberDto;
import com.buildenough.marketboard.post.dto.PostDetailDto;
import com.buildenough.marketboard.post.dto.PostListDto;
import com.buildenough.marketboard.post.dto.PostWriteDto;
import com.buildenough.marketboard.post.service.PostService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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

        return "post/write";
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

    @GetMapping("/posts")
    public String list(Model model) {
        List<PostListDto> posts = postService.findAllPosts();
        model.addAttribute("posts", posts);
        return "post/list";
    }

    @GetMapping("/posts/{postId}")
    public String detail(@PathVariable Long postId, Model model) {
        postService.increaseViewCount(postId); // 조회수 상승

        PostDetailDto post = postService.findPostById(postId);
        model.addAttribute("post", post);
        return "post/detail";
    }
}
