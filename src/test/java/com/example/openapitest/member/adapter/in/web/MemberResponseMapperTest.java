package com.example.openapitest.member.adapter.in.web;

import com.example.openapitest.member.domain.Member;
import com.ktown4u.gms.company.adapter.in.web.MemberResponse;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberResponseMapperTest {
    @Test
    void toResponse() {
        Member member = Member.get("name");

        MemberResponseMapper mapper = Mappers.getMapper(MemberResponseMapper.class);
        MemberResponse memberResponse = mapper.toResponse(member);

        assertThat(memberResponse.getId()).isEqualTo(member.getId());
        assertThat(memberResponse.getName()).isEqualTo(member.getName());
    }
}
