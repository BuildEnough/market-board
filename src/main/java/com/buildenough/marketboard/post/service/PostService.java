package com.buildenough.marketboard.post.service;

import com.buildenough.marketboard.post.dto.PostWriteDto;
import com.buildenough.marketboard.post.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostMapper postMapper;

    public void writePost(PostWriteDto postWriteDto) {
        postMapper.insertPost(postWriteDto);
    }
}
