package com.example.MOERADTEACHER.security;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
    entityManagerFactoryRef = "loginEntityManagerFactory",
    transactionManagerRef = "loginTransactionManager",
    basePackages = {
        "com.example.MOERADTEACHER.security"
    }
)
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class LoginConfig {

//    @Primary
    @Bean(name = "loginDataSource")
    @ConfigurationProperties(prefix = "db2.datasource")
    public DataSource loginDataSource() {
        return DataSourceBuilder.create().build();
    }

//    @Primary
    @Bean(name = "loginEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean
    entityManagerFactory(
        EntityManagerFactoryBuilder builder,
        @Qualifier("loginDataSource") DataSource dataSource) {
        return builder.dataSource(dataSource).packages("com.example.MOERADTEACHER.security").persistenceUnit("db2").build();
    }

//    @Primary
    @Bean(name = "loginTransactionManager")
    public PlatformTransactionManager loginTransactionManager(
        @Qualifier("loginEntityManagerFactory") EntityManagerFactory loginEntityManagerFactory ) {
        return new JpaTransactionManager(loginEntityManagerFactory);
    }
}