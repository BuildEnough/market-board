package com.buildenough.marketboard.member.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberLoginDto { // 로그인 시 사용자가 입력한 값을 받은 dto
    private String loginId;
    private String password;
}
