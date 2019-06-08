package com.incidentmng.incidentmng.controller;

import com.incidentmng.incidentmng.helpers.JSONResponse;
import com.incidentmng.incidentmng.model.Services;
import com.incidentmng.incidentmng.model.Services_Users;
import com.incidentmng.incidentmng.model.User;
import com.incidentmng.incidentmng.service.ServicesService;
import com.incidentmng.incidentmng.service.Services_UsersService;
import com.incidentmng.incidentmng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/services_users")
public class Services_UsersController {

    private Services_UsersService services_usersService;
    private ServicesService servicesService;
    private UserService userService;

    @Autowired
    public Services_UsersController(ServicesService servicesService, UserService userService, Services_UsersService services_usersService) {
        this.services_usersService = services_usersService;
        this.servicesService = servicesService;
        this.userService = userService;
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

    @RequestMapping(method = RequestMethod.POST, value = "/{id}")
    public ResponseEntity assignServiceToUser(@RequestBody Map<String, Object> json, @PathVariable Long id) {
        try {
            Date start_date = new SimpleDateFormat("yyyy-MM-dd").parse(json.get("start_date").toString());
            String username = json.get("username").toString();
            Optional<Services> service = servicesService.getServicesById(id);
            User user = userService.getUserByUsername(username);
            Services_Users services_users = new Services_Users(service.get(), user, start_date, null, "true");
            services_usersService.save(services_users);
            return ResponseEntity.status(HttpStatus.OK).body(new JSONResponse("User successfully assigned to service"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new JSONResponse(e.getLocalizedMessage()));
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public ResponseEntity removeAssignServiceToUser(@RequestBody Map<String, Object> json, @PathVariable Long id) {
        try {
            Date end = new SimpleDateFormat("yyyy-MM-dd").parse(json.get("end_date").toString());
            User user = userService.getUserByUsername(json.get("username").toString());
            services_usersService.updateServicesUsers(id, end, user);
            return ResponseEntity.status(HttpStatus.OK).body(new JSONResponse("User successfully removed from service"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new JSONResponse(e.getLocalizedMessage()));
        }
    }

}
