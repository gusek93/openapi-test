package com.example.openapitest.member.adapter.in.web;

import com.example.openapitest.member.application.service.MemberService;
import com.example.openapitest.member.domain.Member;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ktown4u.gms.company.adapter.in.web.MemberRequest;
import com.ktown4u.gms.company.adapter.in.web.MemberResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest
public class  MemberControllerIntegrationTest {
    @Autowired private MockMvc mockMvc;
    @Autowired private ObjectMapper objectMapper;
    @MockBean
    private MemberService memberService;

    @Test
    @DisplayName("적합한 정보로 createMember가 호출 되면 데이터베이스에 저대로 된 정보가 저장된다.")
    public void createMember_successfully() throws Exception {
        // given
        MemberRequest memberRequest = new MemberRequest();
        memberRequest.setName("tddMemberTest");

        String jsonString = objectMapper.writeValueAsString(memberRequest);

        MemberResponse expectedResponse = new MemberResponse();
        expectedResponse.setName(memberRequest.getName());

        Member member = new Member();
        member.setName(memberRequest.getName());

        when(memberService.createMember(memberRequest)).thenReturn(member);

        // when
        MockHttpServletResponse response = mockMvc.perform(
                        post("/member").contentType("application/json").content(jsonString)
            ).andDo(print())
                .andReturn()
                .getResponse();

        // then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).as("테스트가 실패 했습니다.").isEqualTo(objectMapper.writeValueAsString(expectedResponse));
        verify(memberService, times(1)).createMember(memberRequest);
    }

}
