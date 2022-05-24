package com.example.openapitest.member.application.service;

import com.example.openapitest.member.application.port.in.MemberUseCase;
import com.example.openapitest.member.application.port.out.CreateMemberPort;
import com.example.openapitest.member.application.port.out.SelectMemberPort;
import com.example.openapitest.member.domain.Member;
import io.tej.SwaggerCodgen.model.MemberRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class MemberService implements MemberUseCase {

    private final CreateMemberPort createMemberPort;
    private final SelectMemberPort selectMemberPort;

    public MemberService(CreateMemberPort createMemberPort, SelectMemberPort selectMemberPort) {
        this.createMemberPort = createMemberPort;
        this.selectMemberPort = selectMemberPort;
    }

    @Override
    public Member creatMember(MemberRequest request) {
        Member member = new Member();
        member.setName(request.getName());

        return createMemberPort.save(member);
    }

    @Override
    public List<Member> getMember() {

        return selectMemberPort.get();
    }
}
