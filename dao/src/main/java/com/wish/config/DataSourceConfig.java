package com.wish.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * Created by wish on 2018/9/7.
 */
//@Configuration
public class DataSourceConfig {

//    @Bean(name = "dataSource")
//    @Qualifier("dataSource")
//    @ConfigurationProperties(prefix = "spring.datasource")
//    @Primary
//    public DataSource primaryDataSource() {
//        return DataSourceBuilder.create().build();
//    }
}
