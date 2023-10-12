package com.example.MOERADTEACHER;



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
    entityManagerFactoryRef = "commonEntityManagerFactory",
    transactionManagerRef = "commonTransactionManager",
    basePackages = {
        "com.example.MOERADTEACHER.common"
    }
)
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class CommonConfig {

    @Primary
    @Bean(name = "commonDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource commonDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "commonEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean
    entityManagerFactory(
        EntityManagerFactoryBuilder builder,
        @Qualifier("commonDataSource") DataSource dataSource) {
        return builder.dataSource(dataSource).packages("com.example.MOERADTEACHER.common").persistenceUnit("db1").build();
    }

    @Primary
    @Bean(name = "commonTransactionManager")
    public PlatformTransactionManager commonTransactionManager(
        @Qualifier("commonEntityManagerFactory") EntityManagerFactory commonEntityManagerFactory ) {
        return new JpaTransactionManager(commonEntityManagerFactory);
    }
}