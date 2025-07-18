package org.example.entity;

import lombok.Getter;
import lombok.Setter;
import org.example.enumiration.TaskProjectStatus;

import java.util.Date;

@Setter
@Getter
public class Task extends AbstractEntity{
    private String name;
    private String description;
    private TaskProjectStatus status;
    private Date startDate;
    private Date endDate;

//    private User user;
//    private Project project;
//    private String userId;
    private String projectId;

    public Task() {
        super();
    }
}
