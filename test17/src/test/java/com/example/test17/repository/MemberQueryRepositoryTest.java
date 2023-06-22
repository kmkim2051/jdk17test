package com.example.test17.repository;

import com.example.test17.entity.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MemberQueryRepositoryTest {
    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberQueryRepository memberQueryRepository;

    @Test
    void findById() {
        // given
        Member member1 = new Member("hello", "1234", "qq22", "seoul");
        Member member2 = new Member("hi", "4567", "ww33", "busan");
        memberRepository.save(member1);
        memberRepository.save(member2);
        // when
        Member findMember = memberQueryRepository.findById("hello");
        // then
        Assertions.assertThat(member1.getId()).isEqualTo(findMember.getId());
        Assertions.assertThat(member2.getEmail()).isEqualTo(findMember.getEmail());
    }

    @Test
    void findAll() {
        List<Member> memberList = memberRepository.findAll();
        Assertions.assertThat(memberList.size()).isEqualTo(4);
    }

}