package com.example.openapitest.member.adapter.out.persistence;

import com.example.openapitest.member.application.port.out.CreateMemberPort;
import com.example.openapitest.member.application.port.out.SelectMemberPort;
import com.example.openapitest.member.application.port.out.UpdateMemberPort;
import com.example.openapitest.member.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MemberPersistenceAdapter implements CreateMemberPort, SelectMemberPort, UpdateMemberPort {

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
        List<Member> members = new ArrayList<>();

        memberList.forEach(e -> members.add(
            Member.of(
                e.getId(),
                e.getName()
            )
        ));
        return members;
    }

    @Override
    public Member update(Member member) {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setId(member.getId());
        memberEntity.setName(member.getName());

        MemberEntity e = memberRepository.save(memberEntity);

        return Member.of(
            e.getId(),
            e.getName()
        );
    }
}
