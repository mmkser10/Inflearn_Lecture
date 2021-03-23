package com.oflo.spring_core.order;

import com.oflo.spring_core.discount.DiscountPolicy;
import com.oflo.spring_core.discount.FixDiscountPolicy;
import com.oflo.spring_core.discount.RateDiscountPolicy;
import com.oflo.spring_core.member.Member;
import com.oflo.spring_core.member.MemberRepository;
import com.oflo.spring_core.member.MemoryMemberRepository;

public class OrderServiceImpi implements OrderService{

//    아래 방식의 문제점
//
//    1. DIP 위반
//    클라이언트 -> 추상 + 클라이언트 -> 구현 관계를 가진다. 분명 추상클래스에만 의존성을 가져야 하지만 둘다 가져버린 상황.
//    2. OCP 위반
//    현재 기능 확장 시 new FixDiscountPolicy()에서 new RateDiscountPolicy()로 코드를 변경해야함.
//
//    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    private MemberRepository memberRepository;
    private DiscountPolicy discountPolicy;

    public OrderServiceImpi(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
