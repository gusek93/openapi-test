package com.example.openapitest.member.adapter.out.persistence;

import com.example.openapitest.member.application.port.out.CreateMemberPort;
import com.example.openapitest.member.application.port.out.SelectMemberPort;
import com.example.openapitest.member.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberPersistenceAdapter implements CreateMemberPort, SelectMemberPort {

    private final MemberRepository memberRepository;

    public MemberPersistenceAdapter(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Member save(Member member) {
        MemberEntity memberEntity  = new MemberEntity();
        memberEntity.setName(member.getName());

        MemberEntity e = memberRepository.save(memberEntity);

        return Member.of(
            e.getId(),
            e.getName()
        );
    }

    @Override
    public List<Member> get() {
        List<MemberEntity> memberList = memberRepository.findAll();
        return null;
    }
}
