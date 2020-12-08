package com.caimj.java.week07.rwSplit.v2;

import com.caimj.java.week07.rwSplit.v2.service.OrderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {


    public static void main(String[] args) {

        ApplicationContext ac = SpringApplication.run(Application.class, args);
        OrderService orderService = ac.getBean(OrderService.class);
        orderService.addOrder();
        orderService.getOrder();
    }
}
