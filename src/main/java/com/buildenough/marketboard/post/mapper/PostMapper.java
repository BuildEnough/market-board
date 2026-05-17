package com.buildenough.marketboard.post.mapper;

import com.buildenough.marketboard.post.dto.PostDetailDto;
import com.buildenough.marketboard.post.dto.PostListDto;
import com.buildenough.marketboard.post.dto.PostUpdateDto;
import com.buildenough.marketboard.post.dto.PostWriteDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {
    void insertPost(PostWriteDto postWriteDto);

    List<PostListDto> findAllPosts();

    PostDetailDto findPostById(Long postId);

    void increaseViewCount(Long postId);

    void updatePost(PostUpdateDto postUpdateDto);

    void deletePost(Long postId, Long memberId);
}
