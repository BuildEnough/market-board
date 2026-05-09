package com.buildenough.marketboard.member.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginMemberDto { // 로그인 성공 후 세션에 저장할 회원 정보 dto
    private Long memberId;
    private String loginId;
    private String name;
}
