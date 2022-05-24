package com.example.openapitest.member.application.port.in;

import com.example.openapitest.member.domain.Member;
import io.tej.SwaggerCodgen.model.MemberRequest;

import java.util.List;

public interface MemberUseCase {

    Member creatMember(MemberRequest request);

    List<Member> getMember();

    Member updateMember(Long id, MemberRequest request);


}
