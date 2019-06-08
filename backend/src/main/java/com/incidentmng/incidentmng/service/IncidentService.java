package com.incidentmng.incidentmng.service;

import com.google.gson.JsonObject;
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

    JsonObject getNumbers(long id);

    void updateIncident(long id, Incident incident);

    void assignUser(long id_incident, long id_user);

    ArrayList<Incident> getAllIncidentsForUser(long id);

}
