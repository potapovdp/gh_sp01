package org.example.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.example.enumiration.TaskProjectStatus;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "PROJECT")
public class Project extends AbstractEntity {

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "STATUS")
    private TaskProjectStatus status;

    @Column(name = "START_DATE")
    private Date startDate;

    @Column(name = "END_DATE")
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToMany(mappedBy = "project", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
    private Set<Task> tasks = new HashSet<>();

    public Project() {
        super();
    }

    public boolean addTask(Task task) {
        if (tasks.contains(task)) {
            return false;
        }

        task.setProject(this);
        return getTasks().add(task);
    }

    public boolean removeTask(Task task) {
        if (!tasks.contains(task)) {
            return false;
        }

        task.setProject(null);
        return getTasks().remove(task);
    }
}
