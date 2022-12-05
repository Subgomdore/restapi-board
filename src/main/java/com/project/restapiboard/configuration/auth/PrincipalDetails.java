package com.project.restapiboard.configuration.auth;

// 시큐리티가 /login 주소 요청이 오면 낚아채서 로그인을 진행시킨다.
// 로그인을 진행이 완료가 되면 시큐리티 session 을 만들어준다. (Security ContextHolder)
// Security ContextHolder 안에 들어갈 오브젝트는 -> Authentication 타입의 객체 만 들어 올 수 있다.
// 때문에 Authentication 안에 User 정보가 있어야 함.
// User 오브젝트의 타입 > UserDetails 타입 객체

// Security Session > Authentication > UserDetails(PrincipalDetails)

import com.project.restapiboard.entity.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

@Data
public class PrincipalDetails implements UserDetails, OAuth2User {

    private User user;
    private Map<String, Object> attributes;

    // 일반 로그인 할때 사용하는 생성자
    public PrincipalDetails(User user){
        this.user = user;
    }
    //OAuth 로그인 할때 사용하는 생성자
    public PrincipalDetails(User user, Map<String, Object> attributes){
        this.user = user;
        this.attributes = attributes;
    }

    // 해당 유저의 권한을 리턴하는 곳
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {    // 권한을 리턴 할려고 하는데, role 은 String Type 이다.
        Collection<GrantedAuthority> collect = new ArrayList<>();   // role 을 리턴하기 위해 일단 빈객체를 생성
        collect.add(new GrantedAuthority() {        // 객체에 GrantedAuthority 을 통해서 객체 안에 객체를 넣어서 리턴 시
            @Override
            public String getAuthority() {
                return user.getRole();
            }
        });
        return collect;
    }

    @Override
    public String getPassword() {
        return user.getUserPass();
    }

    @Override
    public String getUsername() {
        return user.getUserId();
    }

    // 계정 만료 인지 여부?
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    // 계정이 잠겼는지 ?
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    // 비밀번호의 기간이 지낫니? (1년이 지낫니? 이런것)
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 게정이 활성화 되어 있니?
    @Override
    public boolean isEnabled() {
        // 예시
        // 1년 동안 로그인 안하면 휴먼계정이라면,
        // 현재시간 - 로그인 시간 = 1년 초과 하면 return false;
        //                     1년 미만이라면 return true;

        return true;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    @Override
    public String getName() {
        return null;
    }
}
