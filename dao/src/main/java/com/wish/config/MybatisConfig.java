package com.wish.config;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by wish on 2018/9/7.
 */
@Configuration
@MapperScan(basePackages = {"com.wish.mapper"}, sqlSessionFactoryRef = "sqlSessionFactory")
public class MybatisConfig {

    @Autowired
    private DataSource dataSource;

    @Bean
    @ConfigurationProperties(prefix = "mybatis.configuration")
    public org.apache.ibatis.session.Configuration globalConfiguration() {
        return new org.apache.ibatis.session.Configuration();
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate() throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory(globalConfiguration())); // 使用上面配置的Factory
        return template;
    }

    @Bean("sqlSessionFactory")
    @Primary
    public SqlSessionFactory sqlSessionFactory(org.apache.ibatis.session.Configuration configuration) {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setConfiguration(configuration);
        //分页插件
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        Properties props = new Properties();
        props.setProperty("pageSqlId", ".*Page$");
        props.setProperty("dialect", "mysql");
        paginationInterceptor.setProperties(props);
        //添加插件
        bean.setPlugins(new Interceptor[]{paginationInterceptor});
        try {
            //指定基包
            bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/*.xml"));
            return bean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
