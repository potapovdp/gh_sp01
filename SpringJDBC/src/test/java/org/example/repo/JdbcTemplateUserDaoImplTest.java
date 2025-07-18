package org.example.repo;

import org.example.config.H2Cfg;
import org.example.config.SpringJdbcTemplateCfg;
import org.example.dao.JdbcTemplateUserDaoImpl;
import org.example.dao.interfaces.UserDAO;
import org.example.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(classes = {H2Cfg.class, SpringJdbcTemplateCfg.class, JdbcTemplateUserDaoImpl.class})
class JdbcTemplateUserDaoImplTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(JdbcTemplateUserDaoImplTest.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserDAO userDao;

    @Autowired
    private JdbcTemplateUserDaoImpl jdbcTemplateUserDao;

    @Test
    void findAll() {
    }

    @Test
    @DisplayName("Should return a users with id = 1")
    void findByIdOld() {
        LOGGER.info("findByIdOld");
        User user = jdbcTemplateUserDao.findByIdOld(1);
        System.out.println(user.getLogin());
        Assertions.assertNotNull(user);
    }

    @Test
    void findById() {
        LOGGER.info("findByIdOld");
        User user = userDao.findById(1);
        System.out.println(user.getLogin());
        Assertions.assertNotNull(user);
    }
}