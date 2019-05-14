package com.incidentmng.incidentmng.repository;

import com.incidentmng.incidentmng.model.IncidentReport;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncidentReportRepository extends CrudRepository<IncidentReport, Long> {
}
