package com.buildenough.marketboard.post.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PostDetailDto {

    private Long postId;
    private Long memberId;
    private String title;
    private String content;
    private String writerName;
    private int viewCount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
