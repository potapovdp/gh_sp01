package org.example.repository.jdbc;

import org.apache.commons.lang3.NotImplementedException;
import org.apache.log4j.Logger;
import org.example.entity.User;
import org.example.enumiration.RoleType;
import org.example.repository.jdbc.interfaces.UserDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class UserDAOImpl implements UserDAO {
    private static Logger logger = Logger.getLogger(UserDAOImpl.class);

    @Override
    public Set<User> findAll() {
        Set<User> users = new HashSet<>();

        try(Connection connection = getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from user");) {
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
            logger.error("Problem execute SELECT in findAllUsers ", e);
        }

        return users;
    }

    @Override
    public User findById(int id) {
        throw new NotImplementedException("Not implemented yet");
    }

    @Override
    public User findByUsername(String username) {
        throw new NotImplementedException("Not implemented yet");
    }

    @Override
    public User insert(User user) {
        try(Connection connection = getConnection();) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO USER (ID, LOGIN, PASSWORD, HASH_PASS, ROLE_TYPE) values (?,?,?,?,?)");
//            connection.setAutoCommit(false);
            statement.setString(1, user.getId());
            statement.setString(2, user.getLogin());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getHashPass());
            statement.setString(5, user.getRole().toString());
            statement.execute();
//            connection.commit();
        } catch (SQLException e) {
            logger.error("Problem execute INSERT in Users", e);
        }

        return user;
    }

    @Override
    public User update(User user) {
        try(Connection connection = getConnection();) {
            PreparedStatement statement = connection.prepareStatement("UPDATE USER SET LOGIN = ?, PASSWORD = ?, HASH_PASS = ?, ROLE_TYPE = ? WHERE ID = ?");
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getHashPass());
            statement.setString(4, user.getRole().toString());
            statement.setString(5, user.getId());
            statement.execute();
        } catch (SQLException e) {
            logger.error("Problem execute UPDATE in Users", e);
        }

        return user;
    }

    @Override
    public void delete(String id) {
        try(Connection connection = getConnection();) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM USER WHERE ID = ?");
            statement.setString(1, id);
            statement.execute();
        } catch (SQLException e) {
            logger.error("Problem execute DELETE in Users", e);
        }
    }
}
