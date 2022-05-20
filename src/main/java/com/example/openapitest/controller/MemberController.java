package com.example.openapitest.controller;

import com.example.openapitest.model.Member;
import com.example.openapitest.service.MemberService;
import io.tej.SwaggerCodgen.api.MemberApi;
import io.tej.SwaggerCodgen.model.MemberRequest;
import io.tej.SwaggerCodgen.model.MemberResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MemberController implements MemberApi {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }


    @Override
    public ResponseEntity<List<MemberResponse>> getMember() {
        List<Member> memberList = memberService.getAllMember();
        List<MemberResponse> members = new ArrayList<>();

        memberList.forEach(e -> members.add(
            new MemberResponse()
                .id(e.getId())
                .name(e.getName())
        ));

        return ResponseEntity.ok(members);
    }

    @Override
    public ResponseEntity<MemberResponse> createMember(MemberRequest memberRequest) {
        Member member = memberService.createMember(memberRequest);
        MemberResponse memberResponse = new MemberResponse()
            .name(member.getName())
            .id(member.getId());

        return ResponseEntity.ok(memberResponse);

    }

//    @Override
//    public ResponseEntity<MemberResponse> updateMember(MemberRequest memberRequest) {
//        Member member = memberService.updateMember(memberRequest);
//        MemberResponse memberResponse = new MemberResponse()
//            .id(member.getId())
//            .name(member.getName());
//
//        return ResponseEntity.ok(memberResponse);
//    }

}
