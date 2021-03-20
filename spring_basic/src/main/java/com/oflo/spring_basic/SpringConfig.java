package com.oflo.spring_basic;

import com.oflo.spring_basic.repository.MemberRepository;
import com.oflo.spring_basic.repository.MemoryMemberRepository;
import com.oflo.spring_basic.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
