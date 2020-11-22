package com.caimj.java.week05.starter;

import com.caimj.java.week05.starter.bean.Klass;
import com.caimj.java.week05.starter.bean.School;
import com.caimj.java.week05.starter.bean.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


/**
 * 自动配置student
 *
 * @author caimeijiao
 */
@Configuration
//@EnableConfigurationProperties
@RequiredArgsConstructor
public class StudentAutoConfiguration {

//    private final Student student;
//
//    @Bean
//    public Klass klass() {
//
//        Klass klass = new Klass();
//        klass.setKlassId(111);
//        klass.setKlassName("AA");
//        klass.getStudents().add(Student.create());
//        return klass;
//    }
//
    @Bean
    public School school() {

        System.out.println("create School ...");
        School school = new School();
        school.setSchoolId(10890);
        school.setSchoolName("AA university");
        school.getKlasses().add(Klass.create());

        return school;
    }

}
