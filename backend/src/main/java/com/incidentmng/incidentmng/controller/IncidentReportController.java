package com.incidentmng.incidentmng.controller;

import com.incidentmng.incidentmng.helpers.JSONResponse;
import com.incidentmng.incidentmng.model.IncidentReport;
import com.incidentmng.incidentmng.service.IncidentReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/incident_report")
public class IncidentReportController {

    private IncidentReportService incidentReportService;

    @Autowired
    public IncidentReportController(IncidentReportService incidentReportService) {
        this.incidentReportService = incidentReportService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getAllIncidentReports() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(incidentReportService.getAllIncidentReports());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new JSONResponse(e.getLocalizedMessage()));
        }
    }

    @RequestMapping(method = RequestMethod.GET,  value = "/{id}")
    public ResponseEntity getIncidentReportById(@PathVariable Long id) {
        try {
            Optional<IncidentReport> incidentReport = incidentReportService.getIncidentReportById(id);
            return incidentReport.isPresent() ? ResponseEntity.status(HttpStatus.OK).body(incidentReport)
                    : ResponseEntity.status(HttpStatus.NOT_FOUND).body(new JSONResponse("Incident report not found."));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new JSONResponse(e.getLocalizedMessage()));
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createIncidentReport(@RequestBody @Valid IncidentReport incidentReport) {
        try {
            IncidentReport incidentReport1 = incidentReportService.save(incidentReport);
            return ResponseEntity.status(HttpStatus.OK).body(incidentReport1);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new JSONResponse(e.getLocalizedMessage()));
        }
    }
    

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity deleteIncidentReport(@PathVariable Long id) {
        try {
            incidentReportService.deleteIncidentReportById(id);
            return ResponseEntity.status(HttpStatus.OK).body(new JSONResponse("Incident report successfully deleted. "));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new JSONResponse(e.getLocalizedMessage()));
        }
    }

    @RequestMapping(value="/getincidentreports/{id}", method=RequestMethod.GET)
    public ResponseEntity requestMethodName(@PathVariable long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(incidentReportService.getReportsFromIncident(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new JSONResponse(e.getLocalizedMessage()));
        }
    }
    
}
