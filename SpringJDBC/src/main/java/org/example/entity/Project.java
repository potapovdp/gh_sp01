package org.example.entity;

import lombok.Getter;
import lombok.Setter;
import org.example.enumiration.TaskProjectStatus;

import java.util.Date;
import java.util.Set;

@Setter
@Getter
public class Project extends AbstractEntity {
    private String name;
    private String description;
    private TaskProjectStatus status;
    private Date startDate;
    private Date endDate;

    private String userId;

    private Set<Task> tasks;

    public Project() {
        super();
    }
}
