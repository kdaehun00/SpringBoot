package com.example.demo.service;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberService {
    private final MemberRepository memberRepository;

    //생성자 주입 + spring container에서 연결
    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Long join(Member member) {
        validateDuplicateEmail(member);
        memberRepository.save(member);

        return memberRepository.save(member).getId();
    }

    // 로그인 메서드 추가
    public Member login(String email, String password) {
        Optional<Member> memberOptional = memberRepository.findByEmail(email);

        if (memberOptional.isPresent()) {
            Member member = memberOptional.get();
            System.out.println("데이터베이스 저장된 비밀번호: " + member.getPassword());
            System.out.println("입력받은 비밀번호: " + password);

            // 비밀번호 비교
            if (member.getPassword().equals(password)) {
                return member; // 로그인 성공
            } else {
                System.out.println("비밀번호 불일치");
            }
        } else {
            System.out.println("해당 이메일의 회원이 없습니다.");
        }

        return null; // 로그인 실패
    }


    //isPresent 뒤의 옵션에 값이 있을 때만 동작.
    public void validateDuplicateEmail(Member member) {
        memberRepository.findByEmail(member.getEmail())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 이메일입니다.");
                });
    }
}
