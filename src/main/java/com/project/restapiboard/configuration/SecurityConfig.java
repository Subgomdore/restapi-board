package com.project.restapiboard.configuration;

import com.project.restapiboard.configuration.oauth.PrincipalOauth2UserService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private PrincipalOauth2UserService principalOauth2UserService;

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
                .loginPage("/loginForm")
                .userInfoEndpoint()
                .userService(principalOauth2UserService);
        // 구글 로그인이 완료 된 후 처리가 필요함. Tip. 코드를 받는것이 아님 > (엑세스토큰, 사용자 정보 프로필 O)
        // 1.코드 받기(인증), 2.엑세스토큰(권한) 3. 사용자 프로필 정보가져오기
        // 4-1. 정보를 토대로 회원가입진행 시키기도 함
        // 4-2. (이메일, 전화번호, 이름, 아이디) 쇼핑몰 -> (집주소) -> (vip) 등 추가로 필요한것이 있다면 추가정보 등록란
    }
}
