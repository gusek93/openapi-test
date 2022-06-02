package com.example.openapitest.member.application.service;

import com.example.openapitest.member.application.port.out.CreateMemberPort;
import com.example.openapitest.member.application.port.out.DeleteMemberPort;
import com.example.openapitest.member.application.port.out.SelectMemberPort;
import com.example.openapitest.member.application.port.out.UpdateMemberPort;
import com.example.openapitest.member.domain.Member;
import com.ktown4u.gms.company.adapter.in.web.MemberRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.platform.engine.TestExecutionResult.failed;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MemberServiceTest {
   private MemberService memberService;

    @Mock private CreateMemberPort createMemberPort;
    @Mock private UpdateMemberPort updateMemberPort;
    @Mock private SelectMemberPort selectMemberPort;
    @Mock private DeleteMemberPort deleteMemberPort;


    @BeforeEach
    void setUp() { memberService = new MemberService(createMemberPort, selectMemberPort, updateMemberPort, deleteMemberPort); }

    @Test
    public void createMember_returns_newly_saved_member() {
        MemberRequest memberRequest = new MemberRequest();
        memberRequest.setName("createServiceTest");

        Member member = memberService.createMember(memberRequest);

        verify(createMemberPort, times(1)).save(any(Member.class));
    }

    @Test
    void createMember_throws_exception_when_code_already_exits() {
        MemberRequest memberRequest = new MemberRequest();
        memberRequest.setName("test");

        when(createMemberPort.getByName(memberRequest.getName())).thenReturn(new Member());

        try {
            memberService.createMember(memberRequest);
            failed(new RuntimeException("RuntimeException should be thrown"));
        } catch (Exception e) {}
    }
}
