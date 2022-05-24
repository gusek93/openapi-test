package com.example.openapitest.member.application.service;

import com.example.openapitest.member.application.port.in.MemberUseCase;
import com.example.openapitest.member.application.port.out.CreateMemberPort;
import com.example.openapitest.member.application.port.out.SelectMemberPort;
import com.example.openapitest.member.application.port.out.UpdateMemberPort;
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
    private final UpdateMemberPort updateMemberPort;

    public MemberService(CreateMemberPort createMemberPort, SelectMemberPort selectMemberPort, UpdateMemberPort updateMemberPort) {
        this.createMemberPort = createMemberPort;
        this.selectMemberPort = selectMemberPort;
        this.updateMemberPort = updateMemberPort;
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


    @Override
    public Member updateMember(Long id, MemberRequest request) {
        Member member = new Member();
        member.setId(id);
        member.setName(request.getName());

        return updateMemberPort.update(member);
    }
}
