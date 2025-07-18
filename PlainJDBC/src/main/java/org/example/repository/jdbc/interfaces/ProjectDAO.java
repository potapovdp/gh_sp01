package org.example.repository.jdbc.interfaces;

import org.example.entity.Project;

import java.util.Set;

public interface ProjectDAO extends CoreDAO{
    Set<Project> findAll();
    Project findById(int id);
    Project findByName(String name);
    Project insert(Project project);
    Project update(Project project);
    void delete(String id);
}
