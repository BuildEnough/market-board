package com.buildenough.marketboard.post.mapper;

import com.buildenough.marketboard.post.dto.PostWriteDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PostMapper {
    void insertPost(PostWriteDto postWriteDto);
}
