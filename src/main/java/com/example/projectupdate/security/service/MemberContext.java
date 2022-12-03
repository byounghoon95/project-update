package com.example.projectupdate.security.service;

import com.example.projectupdate.entity.MemberEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

public class MemberContext extends User {

    private final MemberEntity member;

    public MemberContext(MemberEntity member, Collection<? extends GrantedAuthority> authorities) {
        super(member.getId(), member.getPassword(), authorities);
        this.member = member;
    }

    public MemberEntity getMember() {
        return member;
    }
}
