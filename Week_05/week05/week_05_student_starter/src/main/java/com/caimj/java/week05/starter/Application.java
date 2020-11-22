package com.caimj.java.week05.starter;

import com.caimj.java.week05.starter.bean.Klass;
import com.caimj.java.week05.starter.bean.School;
import com.caimj.java.week05.starter.bean.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ApplicationContext ac = SpringApplication.run(StudentAutoConfiguration.class, args);
        System.out.println(ac.getBean(School.class));
    }

}
