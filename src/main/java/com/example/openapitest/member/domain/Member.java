package com.example.openapitest.member.domain;

import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class Member {

    private Long id;

    private String name;

    public Member() {
    }

    private Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Member of(Long id, String name) {
        return new Member(id, name);
    }

}
