package com.example.openapitest.service;

import com.example.openapitest.model.Member;
import com.example.openapitest.repository.MemberRepository;
import io.tej.SwaggerCodgen.model.MemberRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member createMember(MemberRequest memberRequest) {
        Member member = new Member();
        member.setName(memberRequest.getName());
        return memberRepository.save(member);
    }

    public List<Member> getMember() {
       List<Member> memberList = memberRepository.findAll();

       return memberList;
    }

    public Optional<Member> getMemberById(Long id) {
        return memberRepository.findById(id);
    }

    public Member updateMember(Long id, MemberRequest memberRequest) {
        Member member = getMemberById(id).get();
        member.setName(memberRequest.getName());
        return memberRepository.save(member);
    }

    public void deleteMemberById(Long id) {
        memberRepository.deleteById(id);

    }

}
