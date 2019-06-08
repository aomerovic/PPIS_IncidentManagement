package com.incidentmng.incidentmng.service;

import com.incidentmng.incidentmng.model.IncidentReport;
import com.incidentmng.incidentmng.repository.IncidentReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class IncidentReportServiceImpl implements IncidentReportService {

    private IncidentReportRepository incidentReportRepository;

    @Autowired
    public IncidentReportServiceImpl(IncidentReportRepository incidentReportRepository) {
        this.incidentReportRepository = incidentReportRepository;
    }

    @Override
    public IncidentReport save(IncidentReport incident_report) {
        return incidentReportRepository.save(incident_report);
    }

    @Override
    public Optional<IncidentReport> getIncidentReportById(long id) {
        return incidentReportRepository.findById(id);
    }

    @Override
    public ArrayList<IncidentReport> getAllIncidentReports() {
        ArrayList<IncidentReport> incident_reports = new ArrayList<>();
        incidentReportRepository.findAll().forEach(incident_reports::add);
        return incident_reports;
    }

    @Override
    public Long deleteIncidentReportById(long id) {
         incidentReportRepository.deleteById(id);
         return id;
    }

    @Override
    public ArrayList<IncidentReport> getReportsFromIncident(long id) {
        return incidentReportRepository.getReportsFromIncident(id);
    }
}
