package com.epam.esm.rest_api.configuration;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
@PropertySource(value = {"classpath:application.properties"})
public class DataSourceConfiguration {

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    @Value("${spring.datasource.default-schema}")
    private String defaultSchema;

    @Value("${spring.datasource.initial-size}")
    private Integer initialSize;

    @Bean
    public BasicDataSource createDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setDefaultSchema(defaultSchema);
        dataSource.setInitialSize(initialSize);
        return dataSource;
    }

    @Bean
    public JdbcTemplate createJdbcTemplate() {
        return new JdbcTemplate(createDataSource());
    }

}
