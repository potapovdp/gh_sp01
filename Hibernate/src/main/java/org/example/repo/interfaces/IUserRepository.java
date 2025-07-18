package org.example.repo.interfaces;

import org.example.entities.User;

import java.util.List;

public interface IUserRepository {
    User findByUsername(String username);
    User findById(String id);
    List<User> findAll();
    List<User> findAllWithTasks();
    User save(User user);
    void delete(User user);
}
