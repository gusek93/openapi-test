package com.example.openapitest.member.adapter.in.web;


import com.example.openapitest.member.application.service.MemberService;
import com.example.openapitest.member.domain.Member;
import com.ktown4u.gms.company.adapter.in.web.MemberRequest;
import com.ktown4u.gms.company.adapter.in.web.MemberResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MemberControllerTest {
    private MemberController controller;
    @Mock private MemberService memberService;

    @BeforeEach
    void setUp() { controller = new MemberController(memberService); }

    @Test
    @DisplayName("적합한 정보로 createMember가 호출 되면 데이터베이스에 제대로 된 정보가 저장된다")
    public void createMember_successfully() throws Exception {
        //given
        MemberRequest memberRequest = new MemberRequest();
        memberRequest.setName("tddCreateTest");

        Member member = new Member();
        member.setName(memberRequest.getName());

        when(memberService.createMember(memberRequest)).thenReturn(member);

        ResponseEntity<MemberResponse> response = controller.createMember(memberRequest);

        verify(memberService, times(1)).createMember(memberRequest);
    }


}
