package com.electivesubjectpicker.electivesubjectpicker.DataBase.MonagoDB;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Document(collection = "ListOfSubjects")
public class Department {
    @Id
    private String id;
       
    @Indexed(unique=true)
    private String departmentName;
    
    private List<Subjects> subjects;
}
