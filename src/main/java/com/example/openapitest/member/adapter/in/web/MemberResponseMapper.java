package com.example.openapitest.member.adapter.in.web;

import com.example.openapitest.member.domain.Member;
import com.ktown4u.gms.company.adapter.in.web.MemberResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface MemberResponseMapper {

    @Mapping(source = "name", target = "name")
    MemberResponse toResponse(Member member);

}
