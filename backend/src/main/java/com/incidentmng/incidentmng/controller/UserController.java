package com.incidentmng.incidentmng.controller;

import com.incidentmng.incidentmng.helpers.JSONResponse;
import com.incidentmng.incidentmng.model.User;
import com.incidentmng.incidentmng.service.UserService;
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
@RequestMapping("/korisnik")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getAllUsers() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new JSONResponse(e.getLocalizedMessage()));
        }
    }

    @RequestMapping(method = RequestMethod.GET,  value = "/{id}")
    public ResponseEntity getUserById(@PathVariable Long id) {
        try {
            Optional<User> incident = userService.getUserById(id);
            return incident.isPresent() ? ResponseEntity.status(HttpStatus.OK).body(incident)
                    : ResponseEntity.status(HttpStatus.NOT_FOUND).body(new JSONResponse("User not found."));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new JSONResponse(e.getLocalizedMessage()));
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createUser(@RequestBody @Valid User user) {
        try {
            User user1 = userService.save(user);
            return ResponseEntity.status(HttpStatus.OK).body(user1);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new JSONResponse(e.getLocalizedMessage()));
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        try {
            userService.deleteUserById(id);
            return ResponseEntity.status(HttpStatus.OK).body(new JSONResponse("User successfully deleted. "));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new JSONResponse(e.getLocalizedMessage()));
        }
    }

    @RequestMapping(method=RequestMethod.OPTIONS)
    public ResponseEntity getUser(@RequestPart("username") String username, @RequestPart("password") String pass) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(userService.getUser(username, pass));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new JSONResponse(e.getLocalizedMessage()));
        }
    }

    @RequestMapping(value="/korisnikrole/{id}", method=RequestMethod.GET)
    public ResponseEntity getRole(@PathVariable long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(userService.getRola(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new JSONResponse(e.getLocalizedMessage()));
        }
    }
    
}
