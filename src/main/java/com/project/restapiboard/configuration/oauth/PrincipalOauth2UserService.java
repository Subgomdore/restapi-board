package com.project.restapiboard.configuration.oauth;

import com.project.restapiboard.configuration.auth.PrincipalDetails;
import com.project.restapiboard.configuration.oauth.provider.FacebookUserInfo;
import com.project.restapiboard.configuration.oauth.provider.GoogleUserInfo;
import com.project.restapiboard.configuration.oauth.provider.NaverUserInfo;
import com.project.restapiboard.configuration.oauth.provider.OAuth2UserInfo;
import com.project.restapiboard.entity.User;
import com.project.restapiboard.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {

//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private UserRepository userRepository;

    // 구글로부터 받은 userRequest 데이터에 대한 후처리 되는 함수
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
//        System.out.println("getClientRegistration : "+userRequest.getClientRegistration()); // registrationId 로 어떤 OAuth 로 로그인 했는지 확인 가
//        System.out.println("getAccessToken : "+userRequest.getAccessToken().getTokenValue());
//        System.out.println("getAttributes : "+super.loadUser(userRequest).getAttributes());

        OAuth2User oAuth2User = super.loadUser(userRequest);
//        구글 로그인 버튼 클릭 > 구글로그인 창 > 로그인 완료 > code 를 리턴(OAuth-Client 라이브러리) > AccessToken 요청
//        userRequest 정보 -> 회원 프로필을 받아야함(loadUser 함수 호출 -> 회원 프로필 )
        System.out.println("getAttributes : "+oAuth2User.getAttributes());


//        강제 회원 가입
        OAuth2UserInfo oAuth2UserInfo = null;
        if(userRequest.getClientRegistration().getRegistrationId().equals("google")){
            System.out.println("google login");
            oAuth2UserInfo = new GoogleUserInfo(oAuth2User.getAttributes());
        }else if(userRequest.getClientRegistration().getRegistrationId().equals("facebook")){
            System.out.println("facebook login");
            oAuth2UserInfo = new FacebookUserInfo(oAuth2User.getAttributes());
        }else if(userRequest.getClientRegistration().getRegistrationId().equals("naver")){
            System.out.println("naver login");
            oAuth2UserInfo = new NaverUserInfo((Map)oAuth2User.getAttributes().get("response"));
        }else{
            System.out.println("only google and facebook login");
        }


        String provider = oAuth2UserInfo.getProvider();// google
        String providerId = oAuth2UserInfo.getProviderId();
        String userEmail = oAuth2UserInfo.getEmail();
        String username = provider + "_" + providerId; // google_11111...
        String userPass = "snsLoginPassWord";
//        String userPass = bCryptPasswordEncoder.encode("겟인데어");
        String role = "ROLE_USER";

        User userEntity = userRepository.findByUserId(username);

        System.out.println(userEntity);

        if(userEntity == null){
            userEntity = User.builder()
                    .userId(username)
                    .nickName(username)
                    .userPass(userPass)
                    .userEmail(userEmail)
                    .role(role)
                    .provider(provider)
                    .providerId(providerId)
                    .build();
            userRepository.save(userEntity);
        }
        return new PrincipalDetails(userEntity, oAuth2User.getAttributes());
    }
}
