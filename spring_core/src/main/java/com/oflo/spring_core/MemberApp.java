package com.oflo.spring_core;

import com.oflo.spring_core.member.Grade;
import com.oflo.spring_core.member.Member;
import com.oflo.spring_core.member.MemberService;
import com.oflo.spring_core.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);


        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getId());
        System.out.println("find member = " + findMember.getId());
    }
}
