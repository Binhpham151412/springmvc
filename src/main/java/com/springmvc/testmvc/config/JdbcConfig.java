package com.springmvc.testmvc.config;

import com.springmvc.testmvc.constants.GlobalsConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class JdbcConfig {
    @Bean("dataSource")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(GlobalsConstants.DRIVER_NAME);
        dataSource.setUrl(GlobalsConstants.URL);
        dataSource.setUsername(GlobalsConstants.USERNAME);
        dataSource.setPassword(GlobalsConstants.PASSWORD);
        return dataSource;
    }

    @Bean("jdbcTemplate")
    public JdbcTemplate jdbcTemplate() { //abstractDao
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource()); //DI
        return jdbcTemplate;
    }
}
