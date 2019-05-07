package com.incidentmng.incidentmng.service;

import com.incidentmng.incidentmng.model.Incident;
import com.incidentmng.incidentmng.repository.IncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class IncidentServiceImpl implements IncidentService {

    public IncidentRepository incidentRepository;

    @Autowired
    public IncidentServiceImpl(IncidentRepository incidentRepository) {
        this.incidentRepository = incidentRepository;
    }

    @Override
    public Incident save(Incident incident) {
        return incidentRepository.save(incident);
    }

    @Override
    public Optional<Incident> getIncidentById(long id) {
        return incidentRepository.findById(id);
    }

    @Override
    public ArrayList<Incident> getAllIncidents() {
        ArrayList<Incident> incidents = new ArrayList<>();
        incidentRepository.findAll().forEach(incidents::add);
        return incidents;
    }

    @Override
    public Long deleteIncidentById(long id) {
        incidentRepository.deleteById(id);
        return id;
    }
}
