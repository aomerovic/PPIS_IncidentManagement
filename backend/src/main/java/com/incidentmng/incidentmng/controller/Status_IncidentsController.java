package com.incidentmng.incidentmng.controller;

import com.incidentmng.incidentmng.helpers.JSONResponse;
import com.incidentmng.incidentmng.model.Status_Incidents;
import com.incidentmng.incidentmng.service.Status_IncidentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/status_incident")
public class Status_IncidentsController {

    private Status_IncidentsService status_incidentsService;

    @Autowired
    public Status_IncidentsController(Status_IncidentsService status_incidentsService) {
        this.status_incidentsService = status_incidentsService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getAllStatusIncidents() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(status_incidentsService.getAllStatus_Incidents());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new JSONResponse(e.getLocalizedMessage()));
        }
    }

    @RequestMapping(method = RequestMethod.GET,  value = "/{id}")
    public ResponseEntity getStatusIncidentById(@PathVariable Long id) {
        try {
            Optional<Status_Incidents> status = status_incidentsService.getStatus_IncidentsById(id);
            return status.isPresent() ? ResponseEntity.status(HttpStatus.OK).body(status)
                    : ResponseEntity.status(HttpStatus.NOT_FOUND).body(new JSONResponse("Not found."));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new JSONResponse(e.getLocalizedMessage()));
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createStatusIncident(@RequestBody @Valid Status_Incidents status_incidents) {
        try {
            Status_Incidents status_incidents1 = status_incidentsService.save(status_incidents);
            return ResponseEntity.status(HttpStatus.OK).body(status_incidents1);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new JSONResponse(e.getLocalizedMessage()));
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity deleteStatusIncident(@PathVariable Long id) {
        try {
            status_incidentsService.deleteStatus_IncidentsById(id);
            return ResponseEntity.status(HttpStatus.OK).body(new JSONResponse("Successfully deleted. "));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new JSONResponse(e.getLocalizedMessage()));
        }
    }
}
