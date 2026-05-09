package com.buildenough.marketboard.member.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberJoinDto {

    private String loginId;
    private String password;
    private String name;
    private String email;
}
