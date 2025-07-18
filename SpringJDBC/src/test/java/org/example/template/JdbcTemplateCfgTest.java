package org.example.template;


import org.example.config.H2Cfg;
import org.example.dao.JdbcTemplateUserDaoImpl;
import org.example.dao.interfaces.UserDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.jdbc.Sql;

import javax.sql.DataSource;

//@Sql({"classpath:db/Drop-schema.sql", "classpath:db/CreateTables.sql"})
public class JdbcTemplateCfgTest {

    @Test
    public void testSpringJdbcWithH2Db() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(TestDbCfg.class, JdbcTemplateUserDaoImpl.class);
        JdbcTemplate jdbcTemplate = ctx.getBean(JdbcTemplate.class);
        UserDAO userDAO = ctx.getBean(UserDAO.class);
        Assertions.assertNotNull(jdbcTemplate);
        System.out.println(userDAO.findById(1).getLogin());

        Assertions.assertEquals("admin", userDAO.findById(3).getLogin());
    }

    @Configuration
    @Import(H2Cfg.class)
    static class TestDbCfg {
        @Autowired
        @Qualifier("h2DataSource")
        private DataSource dataSource;


        @Bean
        public JdbcTemplate getJdbcTemplate() {
            JdbcTemplate jdbcTemplate = new JdbcTemplate();
            jdbcTemplate.setDataSource(dataSource);
            return jdbcTemplate;
        }
    }

}

