package com.buildenough.marketboard.post.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostWriteDto {

    private Long memberId;
    private String title;
    private String content;
}
