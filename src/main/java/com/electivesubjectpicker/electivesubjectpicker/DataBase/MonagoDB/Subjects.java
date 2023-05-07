package com.electivesubjectpicker.electivesubjectpicker.DataBase.MonagoDB;
import org.springframework.data.mongodb.core.index.Indexed;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Subjects {

    @Indexed(unique=true)
    private String subjectName;

    private int totalCount; 
    private int count;
    private String description;
}
