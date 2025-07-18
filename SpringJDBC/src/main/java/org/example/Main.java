package org.example;


import org.example.dao.JdbcUserDAOImpl;
import org.example.dao.interfaces.UserDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan
@Configuration
public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        System.out.println("Hello and welcome!");
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Main.class);
        UserDAO userDAO = ctx.getBean(JdbcUserDAOImpl.class);

        logger.info("!!USERS!!");
        userDAO.findAll().forEach(System.out::println);
    }
}