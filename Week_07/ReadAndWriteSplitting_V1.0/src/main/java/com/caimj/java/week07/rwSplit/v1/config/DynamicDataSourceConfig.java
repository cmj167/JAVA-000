package com.caimj.java.week07.rwSplit.v1.config;

import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@PropertySource("classpath:application.properties")
public class DynamicDataSourceConfig {

    @Bean("master")
    @ConfigurationProperties(prefix = "spring.datasource.master")
    public DataSource masterDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean("slave")
    @ConfigurationProperties(prefix = "spring.datasource.slave")
    public DataSource slaveDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Autowired
    @Qualifier("master")
    private DataSource masterDataSource;

    @Autowired
    @Qualifier("slave")
    private DataSource slaveDataSource;
    /**
     * 动态数据源
     *
     * @return
     */
    @Bean
    @Primary
    public DynamicRoutingDataSource dynamicDataSource() {

        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put("master", masterDataSource);
        targetDataSources.put("slave", slaveDataSource);

        DynamicRoutingDataSource dataSource = new DynamicRoutingDataSource();
        //设置数据源映射
        dataSource.setTargetDataSources(targetDataSources);
        //设置默认数据源，当无法映射到数据源时会使用默认数据源
        dataSource.setDefaultTargetDataSource(masterDataSource);
        dataSource.afterPropertiesSet();
        DynamicDataSourceContextHolder.setDataSourceType("master");
        return dataSource;
    }

}
