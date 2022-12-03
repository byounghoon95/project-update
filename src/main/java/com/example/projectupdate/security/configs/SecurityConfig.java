package com.example.projectupdate.security.configs;

import com.example.projectupdate.security.provider.CustomAuthenticationProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    private final AuthenticationFailureHandler failureHandler;
    private final AuthenticationSuccessHandler successHandler;

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authConfiguration) throws Exception {
        return authConfiguration.getAuthenticationManager();
    }

    @Bean
    public CustomAuthenticationProvider authenticationProvider() {
        return new CustomAuthenticationProvider();
    }

    //admin 로그인
    @Bean
    @Order(0)
    SecurityFilterChain adminFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable();
        http
                //가장 위에 경로를 적음으로 admin url이 들어오면 해당 필터 실행
                .antMatcher("/admin/**")
                .authorizeRequests()
                .antMatchers("/admin/login").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN");
        http
                .formLogin()
                .loginPage("/admin/login")
                .loginProcessingUrl("/admin/admin_login_proc")
                .usernameParameter("id")
                .successHandler(successHandler)
                .permitAll();
        http
                .logout()
                .logoutSuccessUrl("/admin/login")
                .permitAll();
        return http.build();
    }

    //user 로그인
    @Bean
    @Order(1)
    SecurityFilterChain userFilterChain(HttpSecurity http) throws Exception {
        //post매핑의 경우 forbidden 발생할 수 있는데 이를 막아줌
        http
                .csrf()
                .disable();
        http
                .authorizeRequests()
                .antMatchers("/user/**", "/login**").permitAll()
                .anyRequest().authenticated();
        http
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login_proc")
                .usernameParameter("id") //loadUserByUsername에서 넘어오는 값의 파라미터 지정
                .successHandler(successHandler)
                .failureHandler(failureHandler)
                .permitAll();
        http
                .logout()
                .logoutSuccessUrl("/login")
                .permitAll();
        return http.build();
    }

    //ignore를 사용하면 보안 필터 자체를 거치지 않게됨
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> {
            web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
            web.ignoring().antMatchers("/favicon.ico", "/resources/**", "/error");
        };
    }
}
