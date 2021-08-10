package me.alxndr.sampleboard;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.alxndr.sampleboard.member.Member;
import me.alxndr.sampleboard.member.MemberRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
@RequiredArgsConstructor
public class SampleBoardApplication implements ApplicationRunner {

    private final MemberRepository memberRepository;

    public static void main(String[] args) {
        SpringApplication.run(SampleBoardApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        log.info(">>>>>>>>>>>>>>> ");
        Member member = Member.createMember();

        memberRepository.save(member);

    }
}
