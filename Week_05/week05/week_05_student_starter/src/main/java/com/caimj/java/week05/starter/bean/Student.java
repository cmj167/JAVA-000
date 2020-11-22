package com.caimj.java.week05.starter.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties(prefix = "student")
@Component
public class Student implements Serializable {

    private int id = 1;
    private String name;
    private String sex;
    private int klassId;

    public static Student create() {
        System.out.println("create Student ...");

        Student student = new Student(1, "cai", "female", 2);
        System.out.println(student);
        return student;
    }
}
