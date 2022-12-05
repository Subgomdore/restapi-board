package com.project.restapiboard.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity  // 스프링 스큐리티 필터가 스프링 필터체인에 등록
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true) // secured 어노테이션 활성화, preAuthorize, postAuthorize 어노테이션 활성
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //해당 메서드의 리턴되는 오브젝트를 IoC로 등록 해준다.
    @Bean
    public BCryptPasswordEncoder encoderPwd(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable();  // csrf 비활성화
        http.authorizeRequests()
                .antMatchers("/user/**").authenticated()    //인증이 필요한 url
                .antMatchers("/manager/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGER')")
                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                .anyRequest().permitAll() // 다른 주소는 모두 접속가능
                .and()
                .formLogin()
                .loginPage("/loginForm")
                .usernameParameter("username")
                .passwordParameter("userPass")
                .loginProcessingUrl("/login") // /login 주소가 호출되면 시큐리티가 낚아채서 대신 로그인을 진행해줌.
                .defaultSuccessUrl("/") // login이 성공적으로 진행되면 메인페이지로 이동
                .and()
                .oauth2Login()
                .loginPage("/loginForm"); // 구글 로그인이 완료 된 후 처리가 필요함.
    }
}
