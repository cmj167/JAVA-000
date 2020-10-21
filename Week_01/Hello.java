package com.caimj.java.week01;

/**
 *
 * 功能：写一个简单的 Hello.java，里面需要涉及基本类型，四则运行，if 和 for，然后自己分析一下对应的字节码
 *
 * @author caimeijiao
 * @date 2020-10-21
 */
public class Hello {

    public static void main(String[] args) {

       int sum = 0;
       int num = 5;
        for (int i = 0; i < num; i++) {
            sum = sum + i;
        }
        System.out.println("sum=" + sum);

       float a = 2.5f;
       double b = 3.0d;
       float x = sum/a;
       if (x > 3) {
           double y = 3 * b;
           System.out.println("y=" + y);
       }

    }
}
