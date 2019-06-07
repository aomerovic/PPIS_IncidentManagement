package com.incidentmng.incidentmng.repository;

import java.util.ArrayList;

import com.incidentmng.incidentmng.model.IncidentReport;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IncidentReportRepository extends CrudRepository<IncidentReport, Long> {

    @Query(value = "SELECT * FROM incident_report WHERE incident_id = :id", nativeQuery = true)
    public ArrayList<IncidentReport> getReportsFromIncident(@Param("id") long id);
    

}

