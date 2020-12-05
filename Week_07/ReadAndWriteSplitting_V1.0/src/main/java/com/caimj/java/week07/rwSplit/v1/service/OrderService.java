package com.caimj.java.week07.rwSplit.v1.service;

import com.caimj.java.week07.rwSplit.v1.config.DynamicDataSourceContextHolder;
import com.caimj.java.week07.rwSplit.v1.dao.OrderDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrderService {

    private Logger logger = LoggerFactory.getLogger(OrderService.class);

    @Autowired
    private OrderDao orderDao;

    public void addOrder() {
        orderDao.addOrder();
    }

    public void getOrder() {

        logger.info("切换数据源到slave库");
        DynamicDataSourceContextHolder.setDataSourceType("slave");
        List<Map<String, Object>> resultList = orderDao.getOrder();
        for (Map<String, Object> map : resultList) {
            logger.info(String.valueOf(map));
        }
    }
}
