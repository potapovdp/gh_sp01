package org.example.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.sql.DataSource;

@Testcontainers
@Configuration
public class TestcontainersConfig {
    private static final Logger log = LoggerFactory.getLogger(TestcontainersConfig.class);

    @Container
    static MySQLContainer<?> mySQLContainer = new MySQLContainer<>("mysql:8.0");

    @PostConstruct
    public void init() {
        mySQLContainer.start();
    }

    @PreDestroy
    public void destroy() {
        mySQLContainer.stop();
    }

    @Bean
    public DataSource dataSource() {
        try {
            BasicDataSource dataSource = new BasicDataSource();
            dataSource.setDriverClassName(mySQLContainer.getDriverClassName());
            dataSource.setUrl(mySQLContainer.getJdbcUrl());
            dataSource.setUsername(mySQLContainer.getUsername());
            dataSource.setPassword(mySQLContainer.getPassword());

            return dataSource;
        } catch (Exception ex) {
            log.error("MySQLContainer TestContainers DataSource bean cannot be\n" +
                    "created!", ex);

            return null;
        }
    }
}

