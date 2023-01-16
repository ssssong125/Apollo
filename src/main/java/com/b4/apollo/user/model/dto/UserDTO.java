package com.b4.apollo.user.model.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class UserDTO /*implements UserDetails*/ {
    private Integer userNo;
    private String userId;
    private String password;
    private String userName;
    private String userTel;
    private String userAddr;
    private String userEmail;
    private String userRole;
    private String userActive;
    private String userEntdate;
    private int point;
//    private Collection<? extends GrantedAuthority> authority;
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return authority;
//    }
//
//    @Override
//    public String getPassword(){
//        return  this.password;
//    }
//    @Override
//    public String getUsername(){
//        return this.username;
//
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
}
