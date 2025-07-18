package org.example.dao;

import org.example.dao.interfaces.UserDAO;
import org.example.entity.User;
import org.example.enumiration.RoleType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

@Repository
public class JdbcUserDAOImpl implements UserDAO, InitializingBean {
    private static final Logger logger = LoggerFactory.getLogger(JdbcUserDAOImpl.class);
    private DataSource dataSource;

    @Autowired
    @Qualifier("getBasicDataSource")
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        if (dataSource == null) {
            throw new BeanCreationException("Property 'dataSource' is required in UserDAOImpl");
        }
    }

    @Override
    public Set<User> findAll() {
        Set<User> users = new HashSet<>();
        try(Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("select * from users");
            ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getString("id"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setHashPass(resultSet.getString("HASH_PASS"));
                user.setRole(RoleType.valueOf(resultSet.getString("ROLE_TYPE")));
                users.add(user);
            }

        } catch (SQLException e) {
            logger.error("Problem when executing SELECT! in findAll in USER-table", e);
        }
        return users;
    }


    @Override
    public User findById(int id) {
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from user where id = ?");
            ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getString("id"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setHashPass(resultSet.getString("HASH_PASS"));
                user.setRole(RoleType.valueOf(resultSet.getString("ROLE_TYPE")));
                return user;
            }
        } catch (SQLException e) {
            logger.error("Problem when executing SELECT! in findById in USER-table", e);
        }
        return null;
    }
}
