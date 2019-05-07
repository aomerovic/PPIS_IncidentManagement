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

    @Column(name = "service_name")
    @NotNull
    private String serviceName;

    @Column(name = "category")
    @NotNull
    private String category;

    @Column(name = "description")
    @NotNull
    private String description;

    @Column(name = "status")
    @NotNull
    @Min(value = 0, message = "Value has to be 0 or 1")
    @Max(value = 1, message = "Value has to be 0 or 1")
    private Integer status;

    @Column(name = "priority")
    @NotNull
    private String priority;

    @Column(name = "date")
    @NotNull
    private Date date;

    public Incident() {
    }

    public Incident(long id, String serviceName, String category, String description, Integer status, String priority, Date date) {
        this.id = id;
        this.serviceName = serviceName;
        this.category = category;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
