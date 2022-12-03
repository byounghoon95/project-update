package com.example.projectupdate.dto.response;

import com.example.projectupdate.entity.MemberEntity;
import lombok.Data;

@Data
public class LoginResponse {

    private String id;
    private String password;

    public LoginResponse(MemberEntity entity) {
        this.id = entity.getId();
        this.password = entity.getPassword();
    }
}
