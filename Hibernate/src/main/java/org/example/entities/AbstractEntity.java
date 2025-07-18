package org.example.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Setter
@Getter
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {
    @Id
    @Column(nullable = false)
    private String id;

    @Version
    @Column(name = "VERSION")
    private int version;

    public AbstractEntity() {
        id = UUID.randomUUID().toString();
    }
}
