package com.example.openapitest.member.application.port.in;

import com.example.openapitest.member.domain.Member;
import com.ktown4u.gms.company.adapter.in.web.MemberRequest;

import java.util.List;

public interface MemberUseCase {

    Member createMember(MemberRequest request);

    List<Member> getMember();

    Member updateMember(Long id, MemberRequest request);

    Member getMemberById(Long id);

    void deleteMember(Long id);


}
