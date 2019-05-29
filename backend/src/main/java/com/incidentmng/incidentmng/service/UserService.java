package com.incidentmng.incidentmng.service;

import com.incidentmng.incidentmng.model.Role;
import com.incidentmng.incidentmng.model.Services;
import com.incidentmng.incidentmng.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public interface UserService {
    User save(User user);

    Optional<User> getUserById(long id);

    ArrayList<User> getAllUsers();

    Long deleteUserById(long id);

    User getUser(String username, String Pass);

    String getRola(long id);

    String getUserId(String username);

    User getUserByUsername(String username);
}
