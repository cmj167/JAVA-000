package com.caimj.java.week07.rwSplit.v2.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Repository
public class OrderDao {

    private Logger logger = LoggerFactory.getLogger(OrderDao.class);

    @Resource
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void init() {
        jdbcTemplate  = new JdbcTemplate(dataSource);
    }
    /**
     * 入订单表
     */
    public void addOrder() {
        logger.info("向订单表插入数据");

        String insertSql = "INSERT INTO test.order_info(user_id, goods_id, amount, status, logistics_id) VALUES (1, 1, 2, 1, 1)";
        jdbcTemplate.execute(insertSql);
    }

    /**
     * 查询订单表
     * @return
     */
    public List<Map<String, Object>> getOrder() {
        logger.info("从订单表查询数据");
        String querySql = "select * from order_info";
        return jdbcTemplate.queryForList(querySql);

    }

}
