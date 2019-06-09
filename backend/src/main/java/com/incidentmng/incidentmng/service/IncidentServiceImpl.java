package com.incidentmng.incidentmng.service;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.incidentmng.incidentmng.model.Incident;
import com.incidentmng.incidentmng.repository.IncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class IncidentServiceImpl implements IncidentService {

    private IncidentRepository incidentRepository;

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

    @Override
    public ArrayList<Incident> getIncidentsFromUser(long id){
        return incidentRepository.getIncidentsFromUser(id);
    }

    @Override
    public JsonObject getNumbers(long id) {
        long ukupanBroj = incidentRepository.getNumberOfIncidents(id);
        long rijeseni = incidentRepository.getNuberOfSolvedIncidents(id);
        long aktivni = ukupanBroj - rijeseni;
        String json = "{\"ukupanBroj\": "+ ukupanBroj + ", \"rijeseni\": "+ rijeseni + ", \"aktivni\": "+ aktivni + " }";
        JsonObject jsonObject = new JsonParser().parse(json).getAsJsonObject();
        return jsonObject;
    }

    @Override
    public void updateIncident(long id, Incident incident1) {
        Incident incident = incidentRepository.findById(id).get();
        incident.setCategory(incident1.getCategory());
        incident.setDescription(incident1.getDescription());
        incident.setEscalated(incident1.getEscalated());
        incident.setId(incident1.getId());
        incident.setPriority(incident1.getPriority());
        incident.setReport_date(incident1.getReport_date());
        incident.setService(incident1.getService());
        incident.setUser(incident1.getUser());
        incident.setSid(incident1.getSid());
        incidentRepository.save(incident);
    }

    @Override
    public void assignUser(long id_incident, long id_user) {
        System.out.print(id_user);
        Incident incident = incidentRepository.findById(id_incident).get();
        incident.setHandle_id(id_user);
        incidentRepository.save(incident);

    }

    @Override
    public ArrayList<Incident> getAllIncidentsForUser(long id) {
        return incidentRepository.getAllIncidentsForUser(id);
    }
}
