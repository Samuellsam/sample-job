package com.sandbox.playground1.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
@Getter
public class AppConfig {

    @Value("${spring.datasource.batchSize}")
    private int batchSize;
}
