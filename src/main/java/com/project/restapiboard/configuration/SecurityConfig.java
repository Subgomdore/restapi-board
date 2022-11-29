package com.project.restapiboard.configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity // 기본적인 Web 보안을 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .authorizeRequests()    // HttpServletRequest 를 사용하는 요청들에 대한 접근 제한을 설정하겠다.
                .antMatchers("/main/**").permitAll()  //"" 안에 있는 접근은 인증없이 접근을 허용하겠다. (풀어주는것)
                .anyRequest().authenticated();  // 나머지 요청들에 대해서는 인증을 받아야 한다.
    }
}
