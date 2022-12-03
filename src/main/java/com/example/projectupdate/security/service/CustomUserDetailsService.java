package com.example.projectupdate.security.service;

import com.example.projectupdate.entity.MemberEntity;
import com.example.projectupdate.user.login.repository.LoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
    private final LoginRepository loginRepository;

    @Override
    public UserDetails loadUserByUsername(@RequestParam(value = "id") String id) throws UsernameNotFoundException {
        Optional<MemberEntity> opt = loginRepository.findById(id);

        MemberEntity member = opt.orElseThrow(() -> new UsernameNotFoundException("UsernameNotFound"));

        List<GrantedAuthority> roles = new ArrayList<>();
        roles.add(new SimpleGrantedAuthority(member.getRole())); //DB에 저장되어있는 사용자의 role 정보를 가져옴
        MemberContext memberContext = new MemberContext(member, roles);
        return memberContext;
    }
}
