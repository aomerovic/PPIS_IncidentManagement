package com.incidentmng.incidentmng.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "status")
public class Status {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY,generator = "status_seq" )
    @SequenceGenerator(name = "status_seq", sequenceName = "status_seq", allocationSize = 1)
    private long id;

    @Column(name = "status")
    @NotNull
    private String status;


    public Status() {
    }


    public Status(@NotNull String status) {
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
