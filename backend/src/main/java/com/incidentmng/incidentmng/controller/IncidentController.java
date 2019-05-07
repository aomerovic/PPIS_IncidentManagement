package com.incidentmng.incidentmng.controller;


import com.incidentmng.incidentmng.helpers.JSONResponse;
import com.incidentmng.incidentmng.model.Incident;
import com.incidentmng.incidentmng.service.IncidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/incident")
public class IncidentController {

    private IncidentService incidentService;

    @Autowired
    public IncidentController(IncidentService incidentService) {
        this.incidentService = incidentService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getAllIncidents() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(incidentService.getAllIncidents());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new JSONResponse(e.getLocalizedMessage()));
        }
    }

    @RequestMapping(method = RequestMethod.GET,  value = "/{id}")
    public ResponseEntity getIncidentById(@PathVariable Long id) {
        try {
            Optional<Incident> incident = incidentService.getIncidentById(id);
            return incident.isPresent() ? ResponseEntity.status(HttpStatus.OK).body(incident)
                    : ResponseEntity.status(HttpStatus.NOT_FOUND).body(new JSONResponse("Incident not found."));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new JSONResponse(e.getLocalizedMessage()));
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createIncident(@RequestBody @Valid Incident incident) {
        try {
            Incident incident1 = incidentService.save(incident);
            return ResponseEntity.status(HttpStatus.OK).body(incident1);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new JSONResponse(e.getLocalizedMessage()));
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity deleteIncident(@PathVariable Long id) {
        try {
            incidentService.deleteIncidentById(id);
            return ResponseEntity.status(HttpStatus.OK).body(new JSONResponse("Incident successfully deleted. "));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new JSONResponse(e.getLocalizedMessage()));
        }
    }

}