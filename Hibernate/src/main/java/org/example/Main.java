package org.example;

import org.example.config.HibernateConfig;
import org.example.servise.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(HibernateConfig.class);
        UserService service = ctx.getBean(UserService.class);

        service.allUserOperations();
    }
}