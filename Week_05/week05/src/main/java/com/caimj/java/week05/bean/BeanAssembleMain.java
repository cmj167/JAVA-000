package com.caimj.java.week05.bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * spring bean 装配
 * 两种方式：1.注解 2.xml
 *
 * @author caimeijiao
 */
public class BeanAssembleMain {

    public static void main(String[] args) {

        assembleByXml();

        assembleByAnnotation();

    }

    /**
     * 根据注解装配bean
     */
    public static void assembleByAnnotation() {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(StudentAnnotationBean.class);

        System.out.println("student by annotation");
        System.out.println(applicationContext.getBean("studentByAnnotation"));

    }

    /**
     * 根据xml装配bean
     */
    public static void assembleByXml() {

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");

        System.out.println("student by xml");
        System.out.println(applicationContext.getBean("studentOneByConstructor"));
        System.out.println(applicationContext.getBean("studentTwoBySetter"));

    }

}
