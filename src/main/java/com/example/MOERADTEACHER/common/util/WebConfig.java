package com.example.MOERADTEACHER.common.util;


import javax.sql.DataSource;

//import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class WebConfig {

//	 @Bean(name = "auth_db")
//	 @ConfigurationProperties(prefix = "spring.datasource")
//	 public DataSource dataSource1() {
//	  return DataSourceBuilder.create().build();
//	 }
//
//	 
//	 @Bean(name = "db2")
//	 @ConfigurationProperties(prefix = "db2.second-db")
//	 public DataSource dataSource2() {
//	  return  DataSourceBuilder.create().build();
//	 }
//
//	 @Bean(name = "jdbcTemplate2")
//	 public JdbcTemplate jdbcTemplate2(@Qualifier("db2") DataSource ds) {
//	  return new JdbcTemplate(ds);
//	 }
}
