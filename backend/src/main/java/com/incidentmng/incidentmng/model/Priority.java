package com.incidentmng.incidentmng.model;

import javax.persistence.*;

@Entity
@Table(name = "priority")
public class Priority {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY,generator = "priority_seq" )
    @SequenceGenerator(name = "priority_seq", sequenceName = "priority_seq", allocationSize = 1)
    private long id;

    @Column(name = "priority")
    private String priority;

    public Priority() {
    }

    public Priority(String priority) {
        this.priority = priority;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }
}
