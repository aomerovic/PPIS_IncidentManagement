package com.incidentmng.incidentmng.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "incident")
public class Incident {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY,generator = "incident_seq" )
    @SequenceGenerator(name = "incident_seq", sequenceName = "incident_seq", allocationSize = 1)
    private long id;

    @ManyToOne
    @JoinColumn(name="service_id", referencedColumnName="id")
    @NotNull
    private Services service;

    @ManyToOne
    @JoinColumn(name="category_id", referencedColumnName="id")
    @NotNull
    private Category category;

    @Column(name = "description")
    @NotNull
    private String description;

    @ManyToOne
    @JoinColumn(name="priority_id", referencedColumnName="id")
    @NotNull
    private Priority priority;

    @Column(name = "report_date")
    @NotNull
    private Date report_date;

    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName="id")
    @NotNull
    private User user;

    @Column(name = "escalated")
    @NotNull
    @Min(value = 0, message = "Value has to be 0 or 1")
    @Max(value = 1, message = "Value has to be 0 or 1")
    private Integer escalated;

    public Incident() {
    }

    public Incident(@NotNull Services service, @NotNull Category category, @NotNull String description, @NotNull Priority priority, @NotNull Date report_date, @NotNull User user, @NotNull @Min(value = 0, message = "Value has to be 0 or 1") @Max(value = 1, message = "Value has to be 0 or 1") Integer escalated) {
        this.service = service;
        this.category = category;
        this.description = description;
        this.priority = priority;
        this.report_date = report_date;
        this.user = user;
        this.escalated = escalated;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Services getService() {
        return service;
    }

    public void setService(Services service) {
        this.service = service;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Date getReport_date() {
        return report_date;
    }

    public void setReport_date(Date report_date) {
        this.report_date = report_date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getEscalated() {
        return escalated;
    }

    public void setEscalated(Integer escalated) {
        this.escalated = escalated;
    }
}
