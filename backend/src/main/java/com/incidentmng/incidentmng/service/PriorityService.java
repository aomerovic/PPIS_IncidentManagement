package com.incidentmng.incidentmng.service;

import com.incidentmng.incidentmng.model.Priority;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public interface PriorityService {
    Priority save(Priority priority);

    Optional<Priority> getPriorityById(long id);

    ArrayList<Priority> getAllPriorities();

    Long deletePriorityById(long id);
}
