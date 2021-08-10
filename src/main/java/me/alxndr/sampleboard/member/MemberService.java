package me.alxndr.sampleboard.member;

import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author : Alexander Choi
 * @date : 2021/08/10
 */
@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public Member getMember(Long memberId) {
        Optional<Member> byId = memberRepository.findById(memberId);
        return byId.orElseThrow(() -> new IllegalArgumentException("Member Not Found"));
    }

}
