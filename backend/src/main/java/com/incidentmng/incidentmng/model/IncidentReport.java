package com.incidentmng.incidentmng.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "incident_report")
public class IncidentReport {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY,generator = "incident_report_seq" )
    @SequenceGenerator(name = "incident_report_seq", sequenceName = "incident_report_seq", allocationSize = 1)
    private long id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="incident_id", referencedColumnName="id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Incident incident;

    @Column(name = "report")
    @NotNull
    private String report;

    public IncidentReport() {
    }

    public IncidentReport(Incident incident, @NotNull String report) {
        this.incident = incident;
        this.report = report;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Incident getIncident() {
        return incident;
    }

    public void setIncident(Incident incident) {
        this.incident = incident;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }
}
