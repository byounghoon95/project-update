package com.example.projectupdate.user.login.controller;

import com.example.projectupdate.user.login.service.LoginService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@WebMvcTest(LoginController.class)
class LoginControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    private LoginService loginService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    @DisplayName("메인화면 이동 테스트")
    @WithAnonymousUser
    void main() {
    }

    @Test
    @DisplayName("Login 테스트")
    void login() {

    }
}