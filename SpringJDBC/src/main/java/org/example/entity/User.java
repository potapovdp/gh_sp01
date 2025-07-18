package org.example.entity;

import lombok.Getter;
import lombok.Setter;
import org.example.enumiration.RoleType;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
public class User extends AbstractEntity {

    private String login;
    private String password;
    private String hashPass;

//    private Project project;
    private String projectId;

    private Set<Project> projects = new HashSet<>();
    private Set<Session> sessions = new HashSet<>();

    private RoleType role;

    public User() {
        super();
    }
}
