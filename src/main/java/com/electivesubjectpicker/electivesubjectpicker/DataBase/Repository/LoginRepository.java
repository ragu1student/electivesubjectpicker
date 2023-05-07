package com.electivesubjectpicker.electivesubjectpicker.DataBase.Repository;

import java.util.Optional;

// import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.data.jpa.repository.JpaRepository;

import com.electivesubjectpicker.electivesubjectpicker.DataBase.MySql.LoginDetails;

public interface LoginRepository extends JpaRepository<LoginDetails, Integer>{

    Optional<LoginDetails>  findByUsername(String username);

}
