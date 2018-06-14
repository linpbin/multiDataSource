package com.example.multisource.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.example.multisource.dao.user",sqlSessionFactoryRef = "userSqlSessionFactory")
public class UserDbConfig {
    @Autowired
    @Qualifier("dataSourceOne")
    private DataSource ds;
    @Bean
    public SqlSessionFactory userSqlSessionFactory()throws Exception{
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(ds);
        return  factory.getObject();
    }
    @Bean
    public SqlSessionTemplate userSqlSessionTemplate()throws Exception{
        SqlSessionTemplate template = new SqlSessionTemplate(userSqlSessionFactory());
        return template;
    }
}
