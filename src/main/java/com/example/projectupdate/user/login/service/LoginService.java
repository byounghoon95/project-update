package com.example.projectupdate.user.login.service;

import com.example.projectupdate.dto.request.LoginRequest;
import com.example.projectupdate.dto.request.RegisterRequest;
import com.example.projectupdate.dto.response.LoginResponse;
import com.example.projectupdate.entity.MemberEntity;
import com.example.projectupdate.user.login.repository.LoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.  annotation.Transactional;

import java.util.Optional;

@Transactional
@RequiredArgsConstructor
@Service
public class LoginService {

    private final LoginRepository loginRepository;

    public void register(RegisterRequest request) {
        loginRepository.save(request.toEntity(request.getId(), request.getName(), request.getPassword(), request.getRole()));
    }

	public String idCheck(String id) {
        Optional<MemberEntity> member = loginRepository.findById(id);
        if (member.isPresent()) {
            return member.get().getId();
        } else {
            return "memberNotFoundException";
        }
	}
}
