package com.incidentmng.incidentmng.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "status_incidents")
public class Status_Incidents {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY,generator = "status_incident_seq" )
    @SequenceGenerator(name = "status_incident_seq", sequenceName = "status_incident_seq", allocationSize = 1)
    private long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="status_id", referencedColumnName="id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Status status;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="incident_id", referencedColumnName="id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Incident incident;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="user_id", referencedColumnName="id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;


    @Column(name = "start_date")
    @NotNull
    private Date start_date;

    @Column(name = "end_date")
    @NotNull
    private Date end_date;


    public Status_Incidents() {
    }

    public Status_Incidents(Status status, Incident incident, User user, @NotNull Date start_date, @NotNull Date end_date) {
        this.status = status;
        this.incident = incident;
        this.user = user;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Incident getIncident() {
        return incident;
    }

    public void setIncident(Incident incident) {
        this.incident = incident;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }
}
