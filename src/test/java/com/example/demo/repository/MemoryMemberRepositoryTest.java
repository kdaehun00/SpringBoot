/*package com.example.demo.repository;

import com.example.demo.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();

    @AfterEach
    void clear(){
        memoryMemberRepository.ClearAll();
    }

    @Test
    void save() {
        Member member = new Member();
        member.setEmail("test@gmail.com");
        member.setNickname("test");
        member.setPassword("123456");
        memoryMemberRepository.save(member);

        Member result = memoryMemberRepository.findById(member.getId()).get();
        assertThat(member).isEqualTo(result);
    }

    @Test
    void findByEmail() {
        Member member = new Member();
        member.setEmail("test@gmail.com");
        member.setNickname("test");
        member.setPassword("123456");
        memoryMemberRepository.save(member);

        Member member1 = new Member();
        member1.setEmail("test2@gmail.com");
        member1.setNickname("test2");
        member1.setPassword("123456");
        memoryMemberRepository.save(member1);
        Member result = memoryMemberRepository.findByEmail("test2@gmail.com").get();
        assertThat(result).isEqualTo(member1);
    }

    @Test
    void findByNickname() {
        Member member = new Member();
        member.setEmail("test@gmail.com");
        member.setNickname("test");
        member.setPassword("123456");
        memoryMemberRepository.save(member);

        Member member1 = new Member();
        member1.setEmail("test2@gmail.com");
        member1.setNickname("test2");
        member1.setPassword("123456");
        memoryMemberRepository.save(member1);

        Member result = memoryMemberRepository.findByNickname("test2").get();
        assertThat(result).isEqualTo(member1);
    }
}
*/
