package com.example.openapitest.member.adapter.in.web;

import com.example.openapitest.member.application.port.in.MemberUseCase;
import com.example.openapitest.member.domain.Member;
import com.ktown4u.gms.company.adapter.in.web.MemberApi;
import com.ktown4u.gms.company.adapter.in.web.MemberRequest;
import com.ktown4u.gms.company.adapter.in.web.MemberResponse;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MemberController implements MemberApi {
    private final MemberUseCase memberUseCase;

    public MemberController(MemberUseCase memberUseCase) {
        this.memberUseCase = memberUseCase;
    }


    @Override
    public ResponseEntity<MemberResponse> createMember(MemberRequest memberRequest) {
        Member member = memberUseCase.creatMember(memberRequest);

        return ResponseEntity.ok(toResponse(member));
    }

    private MemberResponse toResponse(Member member) {
        return Mappers.getMapper(MemberResponseMapper.class).toResponse(member);
    }

    @Override
    public ResponseEntity<List<MemberResponse>> getMember() {
        List<MemberResponse> members = memberUseCase.getMember().stream()
            .map(this::toResponse)
            .collect(Collectors.toList());

        return ResponseEntity.ok(members);
    }


    @Override
    public ResponseEntity<MemberResponse> updateMember(Long id, MemberRequest memberRequest) {
        Member member = memberUseCase.updateMember(id, memberRequest);

        return ResponseEntity.ok(toResponse(member));
    }

    @Override
    public ResponseEntity<Void> deleteMember(Long id) {
        memberUseCase.deleteMember(id);
        return new ResponseEntity<Void>(HttpStatus.OK);

    }
}
