package com.incidentmng.incidentmng.service;

import com.incidentmng.incidentmng.model.Services;
import com.incidentmng.incidentmng.model.Services_Users;
import com.incidentmng.incidentmng.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@Service
public interface Services_UsersService {
    Services_Users save(Services_Users services);

    Optional<Services_Users> getServices_UsersById(long id);

    ArrayList<Services_Users> getAllServices_Users();

    Long deleteServices_UsersById(long id);

    void updateServicesUsers(long id, Date date, User user);

    Services_Users findServicesUsers(Services services, User user);
}
