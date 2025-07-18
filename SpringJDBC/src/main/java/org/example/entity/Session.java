package org.example.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Session extends AbstractEntity {
    private boolean active;

    //    private User user;
    private String userId;


    public Session() {
        super();
        active = true;
    }
}
