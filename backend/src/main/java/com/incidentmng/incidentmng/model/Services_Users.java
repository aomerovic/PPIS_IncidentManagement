package com.incidentmng.incidentmng.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Optional;

@Entity
@Table(name = "services_users")
public class Services_Users {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY,generator = "services_users_seq" )
    @SequenceGenerator(name = "services_users_seq", sequenceName = "services_users_seq", allocationSize = 1)
    private long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="service_id", referencedColumnName="id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private Services services;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="user_id", referencedColumnName="id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NotNull
    private User user;

    @Column(name = "start_date")
    @NotNull
    private Date start_date;

    @Column(name = "end_date")
    private Date end_date;

    @Column(name = "active")
    @NotNull
    private String active;

    public Services_Users() {
    }

    public Services_Users(@NotNull Services services, @NotNull User user, @NotNull Date start_date, Date end_date, @NotNull String active) {
        this.services = services;
        this.user = user;
        this.start_date = start_date;
        this.end_date = end_date;
        this.active = active;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
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

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }
}
