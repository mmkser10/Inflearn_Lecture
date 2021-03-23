package com.oflo.spring_core;

import com.oflo.spring_core.discount.RateDiscountPolicy;
import com.oflo.spring_core.member.MemberRepository;
import com.oflo.spring_core.member.MemberService;
import com.oflo.spring_core.member.MemberServiceImpl;
import com.oflo.spring_core.member.MemoryMemberRepository;
import com.oflo.spring_core.order.OrderService;
import com.oflo.spring_core.order.OrderServiceImpi;

public class AppConfig {

    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService(){
        return new OrderServiceImpi(new MemoryMemberRepository(), new RateDiscountPolicy());
    }
}
