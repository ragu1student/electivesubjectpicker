package com.electivesubjectpicker.electivesubjectpicker.Service;

import java.util.Arrays;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.electivesubjectpicker.electivesubjectpicker.DataBase.MySql.LoginDetails;

import java.util.stream.Collectors;

public class UserPrincipal implements UserDetails {

    private String name;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public UserPrincipal(LoginDetails user) {
        this.name = user.getUsername();
        this.password = user.getPassword();
        this.authorities = Arrays.stream(user.getRole().split(","))
                                    .map(SimpleGrantedAuthority::new)
                                    .collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
