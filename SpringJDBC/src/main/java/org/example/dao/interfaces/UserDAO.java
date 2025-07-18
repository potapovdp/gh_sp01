package org.example.dao.interfaces;

import org.example.entity.User;

import java.util.Set;

public interface UserDAO {
    Set<User> findAll();
    User findById(int id);
}
