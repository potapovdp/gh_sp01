package org.example.repo;

import org.example.config.H2Cfg;
import org.example.dao.JdbcUserDAOImpl;
import org.example.dao.interfaces.UserDAO;
import org.example.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.Set;

@SpringJUnitConfig(classes = {H2Cfg.class, JdbcUserDAOImpl.class})
public class JdbcRepoTest {
    private static final Logger logger = LoggerFactory.getLogger(JdbcRepoTest.class);

    @Autowired
    private UserDAO userDAO;

    @Test
    @DisplayName("Should return all users from DB")
    public void testFindAllUsers() {
        logger.info("USERS:");
        Set<User> users = userDAO.findAll();
        users.stream().map(User::getLogin).forEach(System.out::println);
        Assertions.assertEquals(3, users.size());
    }
}
