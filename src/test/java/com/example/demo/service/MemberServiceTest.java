package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional // 테스트 후 데이터 변경을 롤백하여 깨끗한 상태를 유지
class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    void join() {
        Member member = new Member();
        member.setEmail("test@gmail.com");
        member.setPassword("123456");
        member.setNickname("test");

        Long getId = memberService.join(member);

        assertThat(member.getId()).isEqualTo(getId);
    }

    @Test
    void 메일중복검사() {
        Member member = new Member();
        member.setEmail("test@gmail.com");
        member.setPassword("123456");
        member.setNickname("test");
        memberRepository.save(member);

        Member member1 = new Member();
        member1.setEmail("test@gmail.com");
        member1.setPassword("123456");
        member1.setNickname("test1");

        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member1));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 이메일입니다.");
    }
}
