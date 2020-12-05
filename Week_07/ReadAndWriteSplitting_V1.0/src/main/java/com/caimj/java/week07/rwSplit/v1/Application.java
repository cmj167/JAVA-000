package com.caimj.java.week07.rwSplit.v1;

import com.caimj.java.week07.rwSplit.v1.config.DynamicDataSourceConfig;
import com.caimj.java.week07.rwSplit.v1.service.OrderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@Import({DynamicDataSourceConfig.class})
public class Application {


    public static void main(String[] args) {

        ApplicationContext ac = SpringApplication.run(Application.class, args);
        OrderService orderService = ac.getBean(OrderService.class);
        orderService.addOrder();
        orderService.getOrder();
    }
}
