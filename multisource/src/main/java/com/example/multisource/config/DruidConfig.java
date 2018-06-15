package com.example.multisource.config;

import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.alibaba.druid.wall.WallConfig;
import com.alibaba.druid.wall.WallFilter;
import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;
import com.atomikos.jdbc.AtomikosDataSourceBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.sql.DataSource;
import javax.transaction.UserTransaction;
import java.util.Properties;

@Configuration
public class DruidConfig {
//    @Autowired
//    private Environment env;
//    @Primary
//    @Bean
//    @ConfigurationProperties("spring.datasource.druid.one")
//    @Qualifier("dataSourceOne")
//    public DataSource dataSourceOne() {
////        封装XADataSource的实现类为AtomikosDataSourceBean。典型的XADataSource实现包括：
////        1、mysql官方提供的com.mysql.jdbc.jdbc2.optional.MysqlXADataSource
////        2、阿里巴巴开源的druid连接池，对应的实现类为com.alibaba.druid.pool.xa.DruidXADataSource
////        3、tomcat-jdbc连接池提供的org.apache.tomcat.jdbc.pool.XADataSource
//        AtomikosDataSourceBean ds = new AtomikosDataSourceBean();
//        Properties prop = build(env,"spring.datasource.druid.one.");
//        ds.setXaDataSourceClassName("com.alibaba.druid.pool.xa.DruidXADataSource");
//        ds.setUniqueResourceName("dataSourceOne");
//        ds.setPoolSize(5);
//        ds.setXaProperties(prop);
//        return ds;
//    }
    @Primary
    @Bean
    @ConfigurationProperties("spring.datasource.druid.one")
    @Qualifier("dataSourceOne")
    public DataSource dataSourceOne() {
        return DruidDataSourceBuilder.create().build();
    }
//    @Bean
//    @ConfigurationProperties("spring.datasource.druid.two")
//    @Qualifier("dataSourceTwo")
//    public DataSource dataSourceTwo(){
//        AtomikosDataSourceBean ds = new AtomikosDataSourceBean();
//        Properties prop = build(env,"spring.datasource.druid.two.");
//        ds.setXaDataSourceClassName("com.alibaba.druid.pool.xa.DruidXADataSource");
//        ds.setUniqueResourceName("dataSourceTwo");
//        ds.setPoolSize(5);
//        ds.setXaProperties(prop);
//        return ds;
//    }
    @Bean
    @ConfigurationProperties("spring.datasource.druid.two")
    @Qualifier("dataSourceTwo")
    public DataSource dataSourceTwo(){
        return DruidDataSourceBuilder.create().build();
    }
    /**
     * 注入事物管理器
     * @return
     */
    // 实现了JTA/XA规范中的事务管理器(Transaction Manager)应该实现的相关接口
    // UserTransaction实现是com.atomikos.icatch.jta.UserTransactionImp，用户只需要直接操作这个类
    // TransactionManager实现是com.atomikos.icatch.jta.UserTransactionManager
    // Transaction实现是com.atomikos.icatch.jta.TransactionImp
//    @Bean(name = "xatx")
//    public JtaTransactionManager regTransactionManager () {
//        UserTransactionManager userTransactionManager = new UserTransactionManager();
//        UserTransaction userTransaction = new UserTransactionImp();
//        return new JtaTransactionManager(userTransaction, userTransactionManager);
//    }
//    private Properties build(Environment env, String prefix) {
//        Properties prop = new Properties();
//        prop.put("url", env.getProperty(prefix + "url"));
//        prop.put("username", env.getProperty(prefix + "username"));
//        prop.put("password", env.getProperty(prefix + "password"));
//        prop.put("driverClassName", env.getProperty(prefix + "driverClassName", ""));
////        prop.put("initialSize", env.getProperty(prefix + "initialSize", Integer.class));
////        prop.put("maxActive", env.getProperty(prefix + "maxActive", Integer.class));
////        prop.put("minIdle", env.getProperty(prefix + "minIdle", Integer.class));
////        prop.put("maxWait", env.getProperty(prefix + "maxWait", Integer.class));
////        prop.put("poolPreparedStatements", env.getProperty(prefix + "poolPreparedStatements", Boolean.class));
////        prop.put("maxPoolPreparedStatementPerConnectionSize",
////                env.getProperty(prefix + "maxPoolPreparedStatementPerConnectionSize", Integer.class));
////        prop.put("maxPoolPreparedStatementPerConnectionSize",
////                env.getProperty(prefix + "maxPoolPreparedStatementPerConnectionSize", Integer.class));
////        prop.put("validationQuery", env.getProperty(prefix + "validationQuery"));
////        prop.put("validationQueryTimeout", env.getProperty(prefix + "validationQueryTimeout", Integer.class));
////        prop.put("testOnBorrow", env.getProperty(prefix + "testOnBorrow", Boolean.class));
////        prop.put("testOnReturn", env.getProperty(prefix + "testOnReturn", Boolean.class));
////        prop.put("testWhileIdle", env.getProperty(prefix + "testWhileIdle", Boolean.class));
////        prop.put("timeBetweenEvictionRunsMillis",
////                env.getProperty(prefix + "timeBetweenEvictionRunsMillis", Integer.class));
////        prop.put("minEvictableIdleTimeMillis", env.getProperty(prefix + "minEvictableIdleTimeMillis", Integer.class));
////        prop.put("filters", env.getProperty(prefix + "filters"));
//        return prop;
//    }
//    @Bean
//    public ServletRegistrationBean druidServlet() {
//        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
//
//        //控制台管理用户，加入下面2行 进入druid后台就需要登录
//        //servletRegistrationBean.addInitParameter("loginUsername", "admin");
//        //servletRegistrationBean.addInitParameter("loginPassword", "admin");
//        return servletRegistrationBean;
//    }
//    @Bean
//    public FilterRegistrationBean filterRegistrationBean() {
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//        filterRegistrationBean.setFilter(new WebStatFilter());
//        filterRegistrationBean.addUrlPatterns("/*");
//        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
//        filterRegistrationBean.addInitParameter("profileEnable", "true");
//        return filterRegistrationBean;
//    }
//    @Bean
//    public StatFilter statFilter(){
//        StatFilter statFilter = new StatFilter();
//        statFilter.setLogSlowSql(true); //slowSqlMillis用来配置SQL慢的标准，执行时间超过slowSqlMillis的就是慢。
//        statFilter.setMergeSql(true); //SQL合并配置
//        statFilter.setSlowSqlMillis(1000);//slowSqlMillis的缺省值为3000，也就是3秒。
//        return statFilter;
//    }
//    @Bean
//    public WallFilter wallFilter(){
//        WallFilter wallFilter = new WallFilter();
//        //允许执行多条SQL
//        WallConfig config = new WallConfig();
//        config.setMultiStatementAllow(true);
//        wallFilter.setConfig(config);
//        return wallFilter;
//    }
}
