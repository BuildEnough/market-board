package com.buildenough.marketboard.post.service;

import com.buildenough.marketboard.post.dto.PostDetailDto;
import com.buildenough.marketboard.post.dto.PostListDto;
import com.buildenough.marketboard.post.dto.PostUpdateDto;
import com.buildenough.marketboard.post.dto.PostWriteDto;
import com.buildenough.marketboard.post.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostMapper postMapper;

    public void writePost(PostWriteDto postWriteDto) {
        postMapper.insertPost(postWriteDto);
    }

    public List<PostListDto> findAllPosts() {
        return postMapper.findAllPosts();
    }

    public PostDetailDto findPostById(Long postId) {
        return postMapper.findPostById(postId);
    }

    public void increaseViewCount(Long postId) {
        postMapper.increaseViewCount(postId);
    }

    public void updatePost(PostUpdateDto postUpdateDto) {
        postMapper.updatePost(postUpdateDto);
    }

    public void deletePost(Long postId, Long memberId) {
        postMapper.deletePost(postId, memberId);
    }
}
