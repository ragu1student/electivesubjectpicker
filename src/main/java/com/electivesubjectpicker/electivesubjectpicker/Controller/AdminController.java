package com.electivesubjectpicker.electivesubjectpicker.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.electivesubjectpicker.electivesubjectpicker.DataBase.MonagoDB.Department;
import com.electivesubjectpicker.electivesubjectpicker.DataBase.Repository.DepartmentRepository;

@Controller

public class AdminController {

    @Autowired
    DepartmentRepository departmentRepository;




    // create a new department
    @PostMapping("/createDepartment")
    @ResponseBody
    public Optional<Department> addDepartment(@RequestBody Department department) {
        
        System.out.println(department.toString());

        if(departmentRepository.existsByDepartmentName(department.getDepartmentName()))
            return departmentRepository.findByDepartmentName(department.getDepartmentName());

        return departmentRepository.findById(departmentRepository.save(department).getId());
    }


    //  give the list of all the department
    @GetMapping("/getDepartment")
    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseBody
    public List<Department> getDepartment() {
        return departmentRepository.findAll();
    }
}
