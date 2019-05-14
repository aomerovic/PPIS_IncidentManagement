package com.incidentmng.incidentmng.service;

import com.incidentmng.incidentmng.model.Status_Incidents;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;


@Service
public interface Status_IncidentsService {
    Status_Incidents save(Status_Incidents status_incidents);
    Optional<Status_Incidents> getStatus_IncidentsById(long id);
    ArrayList<Status_Incidents> getAllStatus_Incidents();
    Long deleteStatus_IncidentsById(long id);
}
