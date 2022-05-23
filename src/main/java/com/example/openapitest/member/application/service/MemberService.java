package com.example.openapitest.applycation;

import com.example.openapitest.member.adapter.domain.Member;
import com.example.openapitest.repository.MemberRepository;
import io.tej.SwaggerCodgen.model.MemberRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    public List<Member> getAllMember() {
        List<Member> memberList = memberRepository.findAll();
        return memberList;
    }


    public Member createMember(MemberRequest request) {
        Member member = new Member();
        member.setName(request.getName());
        return memberRepository.save(member);

    }

    public Member updateMember(MemberRequest request) {
        Member member = new Member();
        member.setName(request.getName());
        member.setId(request.getId());

        return memberRepository.save(member);
    }
}
