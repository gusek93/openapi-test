package com.example.openapitest.member.application.port.out;

import com.example.openapitest.member.domain.Member;

public interface UpdateMemberPort {

    Member update(Member member);

    Member findById(Long id);
}
