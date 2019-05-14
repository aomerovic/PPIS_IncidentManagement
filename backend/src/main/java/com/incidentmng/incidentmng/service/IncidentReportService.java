package com.incidentmng.incidentmng.service;

import com.incidentmng.incidentmng.model.IncidentReport;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public interface IncidentReportService {
    IncidentReport save(IncidentReport incident_report);

    Optional<IncidentReport> getIncidentReportById(long id);

    ArrayList<IncidentReport> getAllIncidentReports();

    Long deleteIncidentReportById(long id);
}
