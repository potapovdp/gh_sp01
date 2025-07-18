package org.example.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.example.enumiration.RoleType;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "USERS")
public class User extends AbstractEntity {

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "HASH_PASS")
    private String hashPass;

    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    private Set<Project> projects = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    private Set<Session> sessions = new HashSet<>();

    @Column(name = "ROLE_TYPE")
    private RoleType role;

    public User() {
        super();
    }

    public boolean addProject(Project project) {
        if (getProjects().contains(project)) {
            return false;
        }

        project.setUser(this);
        return getProjects().add(project);
    }

    public boolean removeProject(Project project) {
        if (!getProjects().contains(project)) {
            return false;
        }

        project.setUser(null);
        return getProjects().remove(project);
    }

    public boolean addSession(Session session) {
        if (getSessions().contains(session)) {
            return false;
        }

        session.setUser(this);
        return getSessions().add(session);
    }

    public boolean removeSession(Session session) {
        if (!getSessions().contains(session)) {
            return false;
        }

        session.setUser(null);
        return getSessions().remove(session);
    }
}
