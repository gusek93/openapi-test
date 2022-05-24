package com.example.openapitest.member.application.port.out;

import com.example.openapitest.member.domain.Member;

import java.util.List;

public interface SelectMemberPort {

    List<Member> get();
}
