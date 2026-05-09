package com.buildenough.marketboard.member.mapper;

import com.buildenough.marketboard.member.dto.MemberJoinDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    void insertMember(MemberJoinDto member);
}
