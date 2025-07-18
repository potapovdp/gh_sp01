package org.example.repository.jdbc.interfaces;

import org.example.entity.User;

import java.util.Set;

public interface UserDAO extends CoreDAO{
    Set<User> findAll();
    User findById(int id);
    User findByUsername(String username);
    User insert(User user);
    User update(User user);
    void delete(String id);
}
