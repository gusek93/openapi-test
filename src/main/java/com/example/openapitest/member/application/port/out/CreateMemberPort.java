package com.example.openapitest.member.application.port.out;

import com.example.openapitest.member.domain.Member;

public interface CreateMemberPort {
    Member save(Member member);

    Member getByName(String member);

}
