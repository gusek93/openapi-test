package com.example.openapitest.member.adapter.in.web;

import com.example.openapitest.member.adapter.out.persistence.MemberRepository;
import com.example.openapitest.member.application.port.in.MemberUseCase;
import com.example.openapitest.member.domain.Member;
import io.tej.SwaggerCodgen.api.MemberApi;
import io.tej.SwaggerCodgen.model.MemberRequest;
import io.tej.SwaggerCodgen.model.MemberResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MemberController implements MemberApi {
    private final MemberUseCase memberUseCase;

    public MemberController(MemberUseCase memberUseCase) {
        this.memberUseCase = memberUseCase;
    }


    @Override
    public ResponseEntity<MemberResponse> createMember(MemberRequest memberRequest) {
        Member member = memberUseCase.creatMember(memberRequest);

        MemberResponse memberResponse = new MemberResponse()
            .id(member.getId())
            .name(member.getName());

        return ResponseEntity.ok(memberResponse);
    }

    @Override
    public ResponseEntity<List<MemberResponse>> getMember() {

        List<Member> memberList= memberUseCase.getMember();
        List<MemberResponse> members = new ArrayList<>();

        memberList.forEach(e -> members.add(
            new MemberResponse()
                .id(e.getId())
                .name(e.getName())
        ));

        return ResponseEntity.ok(members);
    }

    @Override
    public ResponseEntity<MemberResponse> updateMember(Long id, MemberRequest memberRequest) {
        Member member = memberUseCase.updateMember(id, memberRequest);

        MemberResponse memberResponse = new MemberResponse()
            .id(member.getId())
            .name(member.getName());


        return ResponseEntity.ok(memberResponse);
    }

    @Override
    public ResponseEntity<MemberResponse> deleteMember(Long id) {
        return MemberApi.super.deleteMember(id);
    }
}
