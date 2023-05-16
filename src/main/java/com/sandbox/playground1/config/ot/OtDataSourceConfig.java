package com.sandbox.playground1.config.ot;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class OtDataSourceConfig {

    @Bean
    @ConfigurationProperties(value = "spring.datasource.ot")
    public HikariConfig otHikariConfig() {
        return new HikariConfig();
    }

    @Bean("ot-data-source")
    @Primary
    public HikariDataSource otDataSource() {
        return new HikariDataSource(otHikariConfig());
    }

    @Bean("ot-jdbc-template")
    public JdbcTemplate otJdbcTemplate(@Qualifier("ot-data-source") HikariDataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean("ot-trx-manager")
    public PlatformTransactionManager otTransactionManager(HikariDataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
