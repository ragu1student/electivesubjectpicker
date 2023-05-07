package com.electivesubjectpicker.electivesubjectpicker.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import com.electivesubjectpicker.electivesubjectpicker.DataBase.MySql.LoginDetails;
import com.electivesubjectpicker.electivesubjectpicker.DataBase.Repository.LoginRepository;


@Component
public class AllUserDetailsService implements UserDetailsService{

    @Autowired
    private LoginRepository repo; 

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<LoginDetails> userInfo = repo.findByUsername(username);
        return userInfo.map(UserPrincipal::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        // return null;
            }
    }
