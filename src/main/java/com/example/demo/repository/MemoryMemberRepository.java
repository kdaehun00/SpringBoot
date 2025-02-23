/*package com.example.demo.repository;

import com.example.demo.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long seqeunce = 0L;  //sequence 는 그냥 0, 1, 2 ~~ 생성해주는 역할

    @Override
    public Member save(Member member) {
        member.setId(++seqeunce);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByEmail(String email) {
        return store.values().stream()
                .filter(member -> member.getEmail().equals(email))
                .findAny();
    }

    @Override
    public Optional<Member> findByNickname(String nickname) {
        return store.values().stream()
                .filter(member -> member.getNickname().equals(nickname))
                .findAny();
    }

    public void ClearAll(){
        store.clear();
    }
}

 */
