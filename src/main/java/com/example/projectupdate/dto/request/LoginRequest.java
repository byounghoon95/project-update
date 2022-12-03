package com.example.projectupdate.dto.request;

import com.example.projectupdate.entity.MemberEntity;
import lombok.Data;

@Data
public class LoginRequest {
    private String id;
    private String password;

    public MemberEntity toEntity(String id, String password) {
        return MemberEntity.builder()
                .id(id)
                .password(password)
                .build();
    }
}
