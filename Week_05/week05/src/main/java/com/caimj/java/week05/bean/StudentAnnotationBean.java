package com.caimj.java.week05.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.caimj.java.week05.bean")
public class StudentAnnotationBean {

    @Bean(name = "studentByAnnotation")
    public Student getStudent() {
        return new Student(333, "hh", "男", 3);
    }

}
