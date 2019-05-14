package com.incidentmng.incidentmng.service;

import com.incidentmng.incidentmng.model.Status_Incidents;
import com.incidentmng.incidentmng.repository.Status_IncidentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class Status_IncidentsServiceImpl implements Status_IncidentsService {

    private Status_IncidentsRepository status_incidentsRepository;

    @Autowired
    public Status_IncidentsServiceImpl(Status_IncidentsRepository status_incidentsRepository) {
        this.status_incidentsRepository = status_incidentsRepository;
    }

    @Override
    public Status_Incidents save(Status_Incidents status_incidents) {
        return status_incidentsRepository.save(status_incidents);
    }

    @Override
    public Optional<Status_Incidents> getStatus_IncidentsById(long id) {
        return status_incidentsRepository.findById(id);
    }

    @Override
    public ArrayList<Status_Incidents> getAllStatus_Incidents() {
        ArrayList<Status_Incidents> incidents = new ArrayList<>();
        status_incidentsRepository.findAll().forEach(incidents::add);
        return incidents;
    }

    @Override
    public Long deleteStatus_IncidentsById(long id) {
        status_incidentsRepository.deleteById(id);
        return id;
    }
}
