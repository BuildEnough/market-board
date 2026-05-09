package com.buildenough.marketboard.member.mapper;

import com.buildenough.marketboard.member.dto.LoginMemberDto;
import com.buildenough.marketboard.member.dto.MemberJoinDto;
import com.buildenough.marketboard.member.dto.MemberLoginDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

    void insertMember(MemberJoinDto member); // 이건 저장만하고 따로 반환할 값 필요 없음

    LoginMemberDto findLoginMember(MemberLoginDto memberLoginDto); // 로그인 가능한 회원을 찾아서 회원 정보를 돌려줘야하기때문에 LoginMemberDto를 반환
}
