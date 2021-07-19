package com.oflo.springbasic;

import com.oflo.springbasic.repository.MemberRepository;
import com.oflo.springbasic.repository.MemoryMemberRepository;
import com.oflo.springbasic.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}

