package com.incidentmng.incidentmng.controller;

import com.incidentmng.incidentmng.helpers.JSONResponse;
import com.incidentmng.incidentmng.model.Services_Users;
import com.incidentmng.incidentmng.service.Services_UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/services_users")
public class Services_UsersController {

    private Services_UsersService services_usersService;

    @Autowired
    public Services_UsersController(Services_UsersService services_usersService) {
        this.services_usersService = services_usersService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getAllServicesRoles() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(services_usersService.getAllServices_Users());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new JSONResponse(e.getLocalizedMessage()));
        }
    }

    @RequestMapping(method = RequestMethod.GET,  value = "/{id}")
    public ResponseEntity getServicesRolesById(@PathVariable Long id) {
        try {
            Optional<Services_Users> services_users = services_usersService.getServices_UsersById(id);
            return services_users.isPresent() ? ResponseEntity.status(HttpStatus.OK).body(services_users)
                    : ResponseEntity.status(HttpStatus.NOT_FOUND).body(new JSONResponse("Not found."));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new JSONResponse(e.getLocalizedMessage()));
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createServicesRoles(@RequestBody @Valid Services_Users services) {
        try {
            Services_Users services1 = services_usersService.save(services);
            return ResponseEntity.status(HttpStatus.OK).body(services1);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new JSONResponse(e.getLocalizedMessage()));
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity deleteServicesRoles(@PathVariable Long id) {
        try {
            services_usersService.deleteServices_UsersById(id);
            return ResponseEntity.status(HttpStatus.OK).body(new JSONResponse("Successfully deleted. "));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new JSONResponse(e.getLocalizedMessage()));
        }
    }
}
