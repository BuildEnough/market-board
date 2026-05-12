package com.buildenough.marketboard.post.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class PostListDto {

    private Long postId;
    private String title;
    private String writerName;
    private int viewCount;
    private LocalDateTime createdAt;
}
