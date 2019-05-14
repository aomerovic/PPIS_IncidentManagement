package com.incidentmng.incidentmng.controller;
import com.incidentmng.incidentmng.helpers.JSONResponse;
import com.incidentmng.incidentmng.model.Status;
import com.incidentmng.incidentmng.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/status")
public class StatusController {

    private StatusService statusService;

    @Autowired
    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getAllStatus() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(statusService.getAllStatus());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new JSONResponse(e.getLocalizedMessage()));
        }
    }

    @RequestMapping(method = RequestMethod.GET,  value = "/{id}")
    public ResponseEntity getStatusById(@PathVariable Long id) {
        try {
            Optional<Status> status = statusService.getStatusById(id);
            return status.isPresent() ? ResponseEntity.status(HttpStatus.OK).body(status)
                    : ResponseEntity.status(HttpStatus.NOT_FOUND).body(new JSONResponse("Status not found."));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new JSONResponse(e.getLocalizedMessage()));
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createStatus(@RequestBody @Valid Status status) {
        try {
            Status status1 = statusService.save(status);
            return ResponseEntity.status(HttpStatus.OK).body(status1);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new JSONResponse(e.getLocalizedMessage()));
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity deleteStatus(@PathVariable Long id) {
        try {
            statusService.deleteStatusById(id);
            return ResponseEntity.status(HttpStatus.OK).body(new JSONResponse("Status successfully deleted. "));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new JSONResponse(e.getLocalizedMessage()));
        }
    }
}
