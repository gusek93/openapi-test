package com.example.openapitest.member.adapter.out.persistence;


import com.example.openapitest.member.domain.Member;
import org.mapstruct.Mapper;

@Mapper
public interface MemberEntityMapper {

    Member toDomain(MemberEntity e);

    MemberEntity toEntity(Member member);
}
