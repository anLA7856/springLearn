package com.anla.springbean.componet.mybatis;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author anLA7856
 * @date 20-3-15 下午3:45
 * @description
 */
@Configuration
@MapperScan("com.anla.springbean.componet.mybatis.mapper")
public class MybatisCommonConfiguration {
    /**
     * sqlSessionFactory 要在 //@MapperScan("com.anla.springbean.componet.mybatis.mapper") 前
     * @return
     * @throws Exception
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(getDruidDataSource());
        return factoryBean.getObject();
    }


    private DataSource getDruidDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://127.0.0.1/df?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=GMT");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        dataSource.setMaxWait(2000);
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        // dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        return dataSource;
    }
}
