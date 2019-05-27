package com.incidentmng.incidentmng.service;

import com.incidentmng.incidentmng.model.Services;
import com.incidentmng.incidentmng.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ServicesServiceImpl implements ServicesService {

    private ServiceRepository serviceRepository;

    @Autowired
    public ServicesServiceImpl(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    public Services save(Services services) {
        return serviceRepository.save(services);
    }

    @Override
    public Optional<Services> getServicesById(long id) {
        return serviceRepository.findById(id);
    }

    @Override
    public ArrayList<Services> getAllServices() {
        ArrayList<Services> services = new ArrayList<>();
        serviceRepository.findAll().forEach(services::add);
        return services;
    }

    @Override
    public Long deleteServicesById(long id) {
        serviceRepository.deleteById(id);
        return id;
    }

    @Override
    public ArrayList<Services> getServicesFromUser(long id) {
        return serviceRepository.getServices(id);
    }
}
