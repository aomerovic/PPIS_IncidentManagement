package com.incidentmng.incidentmng.service;


import com.incidentmng.incidentmng.model.Services;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public interface ServicesService {
    Services save(Services services);

    Optional<Services> getServicesById(long id);

    ArrayList<Services> getAllServices();

    Long deleteServicesById(long id);

    ArrayList<Services> getServicesFromUser(long id);

}
