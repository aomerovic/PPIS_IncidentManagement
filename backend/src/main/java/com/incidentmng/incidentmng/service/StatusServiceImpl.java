package com.incidentmng.incidentmng.service;

import com.incidentmng.incidentmng.model.Status;
import com.incidentmng.incidentmng.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class StatusServiceImpl implements StatusService {

    private StatusRepository statusRepository;

    @Autowired
    public StatusServiceImpl(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    @Override
    public Status save(Status status) {
        return statusRepository.save(status);
    }

    @Override
    public Optional<Status> getStatusById(long id) {
        return statusRepository.findById(id);
    }

    @Override
    public ArrayList<Status> getAllStatus() {
        ArrayList<Status> statuses = new ArrayList<>();
        statusRepository.findAll().forEach(statuses::add);
        return statuses;
    }

    @Override
    public Long deleteStatusById(long id) {
        statusRepository.deleteById(id);
        return id;
    }
}
