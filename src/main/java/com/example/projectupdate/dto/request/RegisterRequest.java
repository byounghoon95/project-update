package com.example.projectupdate.dto.request;

import com.example.projectupdate.entity.MemberEntity;
import lombok.Data;

@Data
public class RegisterRequest {

    private String id;
    private String name;
    private String password;
    private String role;

    public MemberEntity toEntity(String id, String name, String password, String role) {
        return MemberEntity.builder()
                .id(id)
                .name(name)
                .password(password)
                .role(role)
                .build();
    }
}
