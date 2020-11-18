package com.caimj.java.week05.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Klass {

    private int  klassId;
    private String klassName;
    private List<Student> students;

}
