package com.example.openapitest.member.adapter.out.persistence;

import com.example.openapitest.member.domain.Member;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberEntityMapperTest {

    private MemberEntityMapper mapper = Mappers.getMapper(MemberEntityMapper.class);

    @Test
    void toDomain() {
        MemberEntity e = new MemberEntity();
        e.setName("mapperTest");

        Member member = mapper.toDomain(e);
        assertThat(member.getName()).isEqualTo(e.getName());
    }
}
