package org.example.repository.jdbc.interfaces;

import org.example.entity.Task;

import java.util.Set;

public interface TaskDAO extends CoreDAO{
    Set<Task> findAll();
    Task findById(int id);
    Task findByName(String name);
    Task insert(Task task);
    Task update(Task task);
    void delete(String id);
}
