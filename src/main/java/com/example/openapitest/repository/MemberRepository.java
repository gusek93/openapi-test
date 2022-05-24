package com.example.openapitest.repository;

import com.example.openapitest.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    @Override
    Optional<Member> findById(Long id);

    @Override
    void deleteById(Long id);
}
