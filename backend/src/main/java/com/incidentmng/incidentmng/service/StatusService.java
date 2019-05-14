package com.incidentmng.incidentmng.service;

import com.incidentmng.incidentmng.model.Status;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public interface StatusService {

    Status save(Status status);

    Optional<Status> getStatusById(long id);

    ArrayList<Status> getAllStatus();

    Long deleteStatusById(long id);
}
