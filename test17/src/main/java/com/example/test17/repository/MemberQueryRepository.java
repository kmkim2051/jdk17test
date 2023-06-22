package com.example.test17.repository;

import com.example.test17.entity.Member;
import com.example.test17.entity.QMember;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.example.test17.entity.QMember.member;

@Repository
@RequiredArgsConstructor
public class MemberQueryRepository {

    private final JPAQueryFactory jpaQueryFactory;

    public Member findById(String id) {
        QMember member = QMember.member;
        Member findMember = jpaQueryFactory.selectFrom(member)
                .where(member.id.eq(id))
                .fetchOne();
        return findMember;
    }

    public List<Member> findAll() {
        return jpaQueryFactory.selectFrom(member).fetch();
    }

}
