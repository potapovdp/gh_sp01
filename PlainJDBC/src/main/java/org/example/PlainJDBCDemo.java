package org.example;

import org.apache.log4j.Logger;
import org.example.entity.User;
import org.example.enumiration.RoleType;
import org.example.repository.jdbc.UserDAOImpl;
import org.example.repository.jdbc.interfaces.UserDAO;

import java.util.Set;

public class PlainJDBCDemo {
    private static final Logger logger = Logger.getLogger(PlainJDBCDemo.class);

    private static final UserDAO userDAO = new UserDAOImpl();

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            logger.error("Problem loading DB Driver", e);
        }
    }

    public static void main(String[] args) {
        Set<User> users = userDAO.findAll();
        System.out.println(users);

        User user = new User();
        user.setId("4");
        user.setLogin("User #44");
        user.setPassword("No password");
        user.setHashPass("qwsa");
        user.setRole(RoleType.User);
        userDAO.insert(user);

        users = userDAO.findAll();
        System.out.println(users);

        userDAO.delete(user.getId());
        users = userDAO.findAll();
        System.out.println(users);
    }
}
