package com.incidentmng.incidentmng.service;

import com.incidentmng.incidentmng.model.Priority;
import com.incidentmng.incidentmng.repository.PriorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class PriorityServiceImpl implements PriorityService {

    private PriorityRepository priorityRepository;

    @Autowired
    public PriorityServiceImpl(PriorityRepository priorityRepository) {
        this.priorityRepository = priorityRepository;
    }


    @Override
    public Priority save(Priority priority) {
        return priorityRepository.save(priority);
    }

    @Override
    public Optional<Priority> getPriorityById(long id) {
        return priorityRepository.findById(id);
    }

    @Override
    public ArrayList<Priority> getAllPriorities() {
        ArrayList<Priority> priorities = new ArrayList<>();
        priorityRepository.findAll().forEach(priorities::add);
        return priorities;
    }

    @Override
    public Long deletePriorityById(long id) {
        priorityRepository.deleteById(id);
        return id;
    }
}
