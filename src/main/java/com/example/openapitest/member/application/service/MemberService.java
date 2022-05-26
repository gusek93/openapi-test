package com.example.openapitest.member.application.service;

import com.example.openapitest.member.application.port.in.MemberUseCase;
import com.example.openapitest.member.application.port.out.CreateMemberPort;
import com.example.openapitest.member.application.port.out.DeleteMemberPort;
import com.example.openapitest.member.application.port.out.SelectMemberPort;
import com.example.openapitest.member.application.port.out.UpdateMemberPort;
import com.example.openapitest.member.domain.Member;
import com.ktown4u.gms.company.adapter.in.web.MemberRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Slf4j
@Service
public class MemberService implements MemberUseCase {

    private final CreateMemberPort createMemberPort;
    private final SelectMemberPort selectMemberPort;
    private final UpdateMemberPort updateMemberPort;
    private final DeleteMemberPort deleteMemberPort;

    public MemberService(CreateMemberPort createMemberPort, SelectMemberPort selectMemberPort, UpdateMemberPort updateMemberPort, DeleteMemberPort deleteMemberPort) {
        this.createMemberPort = createMemberPort;
        this.selectMemberPort = selectMemberPort;
        this.updateMemberPort = updateMemberPort;
        this.deleteMemberPort = deleteMemberPort;
    }

    @Override
    public Member creatMember(MemberRequest request) {
        Member member = Member.get(request.getName());

        return createMemberPort.save(member);
    }

    @Override
    public List<Member> getMember() {
        return Collections.unmodifiableList(selectMemberPort.get());
    }

    @Override
    public Member getMemberById(Long id) {
        return updateMemberPort.findById(id);
    }

    @Override
    public Member updateMember(Long id, MemberRequest request) {
        Member member = Member.of(id, request.getName());
        return updateMemberPort.update(member);
    }

    @Override
    public void deleteMember(Long id) {
        deleteMemberPort.delete(id);
    }
}
