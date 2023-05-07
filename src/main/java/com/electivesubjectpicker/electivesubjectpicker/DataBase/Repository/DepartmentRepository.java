package com.electivesubjectpicker.electivesubjectpicker.DataBase.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.electivesubjectpicker.electivesubjectpicker.DataBase.MonagoDB.Department;

public interface DepartmentRepository extends MongoRepository<Department, String>{

    boolean existsByDepartmentName(String departmentName);

    Optional<Department> findByDepartmentName(String departmentName);
    
    
}
