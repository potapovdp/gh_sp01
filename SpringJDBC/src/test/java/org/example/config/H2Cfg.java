package org.example.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
@ComponentScan
public class H2Cfg {
    private static final Logger log = LoggerFactory.getLogger(H2Cfg.class);

    @Bean
    public DataSource h2DataSource() {
        try {
            EmbeddedDatabaseBuilder dbBuilder = new EmbeddedDatabaseBuilder();
            return dbBuilder
                    .setType(EmbeddedDatabaseType.H2)
                    .addScripts("classpath:db/Drop-schema.sql","classpath:db/CreateTables.sql", "classpath:db/InsertData.sql")
                    .build();
        } catch (Exception e) {
            log.error("Embedded DataSource bean cannot be created!", e);
            return null;
        }
    }
}
