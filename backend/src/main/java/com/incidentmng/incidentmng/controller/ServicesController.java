package com.incidentmng.incidentmng.controller;

import com.incidentmng.incidentmng.helpers.JSONResponse;
import com.incidentmng.incidentmng.model.Services;
import com.incidentmng.incidentmng.service.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/usluge")
public class ServicesController {

    private ServicesService servicesService;

    @Autowired
    public ServicesController(ServicesService servicesService) {
        this.servicesService = servicesService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getAllServices() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(servicesService.getAllServices());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new JSONResponse(e.getLocalizedMessage()));
        }
    }

    @RequestMapping(method = RequestMethod.GET,  value = "/{id}")
    public ResponseEntity getServiceById(@PathVariable Long id) {
        try {
            Optional<Services> incident = servicesService.getServicesById(id);
            return incident.isPresent() ? ResponseEntity.status(HttpStatus.OK).body(incident)
                    : ResponseEntity.status(HttpStatus.NOT_FOUND).body(new JSONResponse("Service not found."));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new JSONResponse(e.getLocalizedMessage()));
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createService(@RequestBody @Valid Services services) {
        try {
            Services services1 = servicesService.save(services);
            return ResponseEntity.status(HttpStatus.OK).body(services1);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new JSONResponse(e.getLocalizedMessage()));
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity deleteService(@PathVariable Long id) {
        try {
            servicesService.deleteServicesById(id);
            return ResponseEntity.status(HttpStatus.OK).body(new JSONResponse("Service successfully deleted. "));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new JSONResponse(e.getLocalizedMessage()));
        }
    }
}
