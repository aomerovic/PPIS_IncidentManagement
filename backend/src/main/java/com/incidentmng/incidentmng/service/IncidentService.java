package com.incidentmng.incidentmng.service;

import com.incidentmng.incidentmng.model.Incident;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public interface IncidentService {
    Incident save(Incident incident);

    Optional<Incident> getIncidentById(long id);

    ArrayList<Incident> getAllIncidents();

    Long deleteIncidentById(long id);

    ArrayList<Incident> getIncidentsFromUser(long id);

    String getNumbers(long id);

}
