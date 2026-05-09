package com.buildenough.marketboard.member.service;

import com.buildenough.marketboard.member.dto.MemberJoinDto;
import com.buildenough.marketboard.member.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberMapper memberMapper;

    public void join(MemberJoinDto memberJoinDto) {
        memberMapper.insertMember(memberJoinDto);
    }
}
