package com.caimj.java.week05.starter.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString
@ConfigurationProperties(prefix = "klass")
@Component
public class Klass {

    private int  klassId;
    private String klassName;
    private List<Student> students = new ArrayList<>();


    public static Klass create() {

        System.out.println("create Klass ...");

        Klass klass = new Klass();
        klass.setKlassId(10);
        klass.setKlassName("软四");
        klass.getStudents().add(Student.create());
        System.out.println(klass);
        return klass;
    }
}
