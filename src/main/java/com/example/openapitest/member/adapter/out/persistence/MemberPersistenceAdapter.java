package com.example.openapitest.member.adapter.out.persistence;

import com.example.openapitest.member.application.port.out.CreateMemberPort;
import com.example.openapitest.member.application.port.out.DeleteMemberPort;
import com.example.openapitest.member.application.port.out.SelectMemberPort;
import com.example.openapitest.member.application.port.out.UpdateMemberPort;
import com.example.openapitest.member.domain.Member;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MemberPersistenceAdapter implements CreateMemberPort, SelectMemberPort, UpdateMemberPort, DeleteMemberPort {

    private final MemberRepository memberRepository;
    private final MemberEntityMapper mapper;

    public MemberPersistenceAdapter(MemberRepository memberRepository) {

        this.memberRepository = memberRepository;
        mapper = Mappers.getMapper(MemberEntityMapper.class);
    }

    @Override
    public Member save(Member member) {

        return mapper.toDomain(memberRepository.save(mapper.toEntity(member)));
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
    public Member getByName(String member) {
        return null;
    }

    @Override
    public Member update(Member member) {
        return mapper.toDomain(memberRepository.save(mapper.toEntity(member)));
    }

    @Override
    public Member findById(Long id) {
        return mapper.toDomain(memberRepository.getById(id));
    }

    @Override
    public void delete(Long id) {
        memberRepository.deleteById(id);
    }
}
