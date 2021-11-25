//package com.tranquyet.domain;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.oauth2.core.user.OAuth2User;
//
//import java.util.Collection;
//import java.util.Map;
//
//@Slf4j
//public class CustomOAuth2User implements OAuth2User {
//
//    @Autowired
//    private OAuth2User oAuth2User;
//
//    public CustomOAuth2User(OAuth2User oAuth2User){
//        this.oAuth2User = oAuth2User;
//    }
//
//    @Override
//    public Map<String, Object> getAttributes() {
//        return oAuth2User.getAttributes();
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return oAuth2User.getAuthorities();
//    }
//
//    @Override
//    public String getName() {
//        String name = oAuth2User.<String>getAttribute("name");
//        log.info("---------------> Username: "+name);
//        return name;
//    }
//
//    public String getIdUser(){
//        String id = oAuth2User.<String>getAttribute("id");
//        log.info("---------------> ID: "+id);
//        return id;
//    }
//
//
//    public String getEmail(){
//        String email = oAuth2User.<String>getAttribute("email");
//        log.info("----------------> Email: "+email);
//        return email;
//    }
//}
