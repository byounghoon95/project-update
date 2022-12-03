package com.example.projectupdate.security.handler;


import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class SuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    //가고자 한 url 정보를 저장
    private RequestCache requestCache = new HttpSessionRequestCache();
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        setDefaultTargetUrl("/");
        SavedRequest savedRequest = requestCache.getRequest(request, response);
        String adminUrl = "/admin/main";

        if (request.getRequestURI().equals("/admin/admin_login_proc")) {
            redirectStrategy.sendRedirect(request, response, adminUrl);
        }else {
            if (savedRequest != null) {
                // 사용자가 인증을 받기 전에 가고자 했던 Url
                // 들어올 때 /admin을 친 후 login 페이지에서 인증되면 admin으로 바로 이동
                String targetUrl = savedRequest.getRedirectUrl();
                redirectStrategy.sendRedirect(request, response, targetUrl);
            } else {
                // /login으로 들어오는 경우
                redirectStrategy.sendRedirect(request, response, getDefaultTargetUrl());
            }
        }
    }
}