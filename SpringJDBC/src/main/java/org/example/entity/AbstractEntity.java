package org.example.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Setter
@Getter
public abstract class AbstractEntity implements Serializable {
    private String id;
    public AbstractEntity() {
        id = UUID.randomUUID().toString();

    }
}
