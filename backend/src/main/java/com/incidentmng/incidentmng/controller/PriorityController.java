package com.incidentmng.incidentmng.controller;

import com.incidentmng.incidentmng.helpers.JSONResponse;
import com.incidentmng.incidentmng.model.Incident;
import com.incidentmng.incidentmng.model.Priority;
import com.incidentmng.incidentmng.service.PriorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/priority")
public class PriorityController {

    private PriorityService priorityService;

    @Autowired
    public PriorityController(PriorityService priorityService) {
        this.priorityService = priorityService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getAllPriorities() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(priorityService.getAllPriorities());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new JSONResponse(e.getLocalizedMessage()));
        }
    }

    @RequestMapping(method = RequestMethod.GET,  value = "/{id}")
    public ResponseEntity getPriorityById(@PathVariable Long id) {
        try {
            Optional<Priority> priority = priorityService.getPriorityById(id);
            return priority.isPresent() ? ResponseEntity.status(HttpStatus.OK).body(priority)
                    : ResponseEntity.status(HttpStatus.NOT_FOUND).body(new JSONResponse("Priority not found."));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new JSONResponse(e.getLocalizedMessage()));
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createPriority(@RequestBody @Valid Priority priority) {
        try {
            Priority priority1 = priorityService.save(priority);
            return ResponseEntity.status(HttpStatus.OK).body(priority1);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new JSONResponse(e.getLocalizedMessage()));
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity deletePriority(@PathVariable Long id) {
        try {
            priorityService.deletePriorityById(id);
            return ResponseEntity.status(HttpStatus.OK).body(new JSONResponse("Priority successfully deleted. "));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new JSONResponse(e.getLocalizedMessage()));
        }
    }
}
