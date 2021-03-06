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
@MapperScan(basePackages = {"com.example.multisource.dao.income"},sqlSessionFactoryRef = "incomeSqlSessionFactory")
public class IncomeDbConfig {
    @Autowired
    @Qualifier("dataSourceTwo")
    private DataSource ds;
    @Bean
    public SqlSessionFactory incomeSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(ds);
        return factoryBean.getObject();

    }

    @Bean
    public SqlSessionTemplate incomeSqlSessionTemplate() throws Exception {
        SqlSessionTemplate template = new SqlSessionTemplate(incomeSqlSessionFactory());
        return template;
    }
}
