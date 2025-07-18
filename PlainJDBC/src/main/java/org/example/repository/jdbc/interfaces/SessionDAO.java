package org.example.repository.jdbc.interfaces;

import org.example.entity.Session;

import java.util.Set;

public interface SessionDAO extends CoreDAO{
    Set<Session> findAll();
    Session findById(long id);
    Session insert(Session session);
    Session update(Session session);
    void delete(Session session);
}
