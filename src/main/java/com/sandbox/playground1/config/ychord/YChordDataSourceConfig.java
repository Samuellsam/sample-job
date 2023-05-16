package com.sandbox.playground1.config.ychord;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class YChordDataSourceConfig {

    @Bean
    @ConfigurationProperties(value = "spring.datasource.ychord")
    public HikariConfig yChordHikariConfig() {
        return new HikariConfig();
    }

    @Bean("ychord-data-source")
    public HikariDataSource yChordDataSource() {
        return new HikariDataSource(yChordHikariConfig());
    }

    @Bean("ychord-jdbc-template")
    public JdbcTemplate yChordJdbcTemplate(@Qualifier("ychord-data-source") HikariDataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean("ychord-trx-manager")
    public PlatformTransactionManager yChordTransactionManager(HikariDataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
