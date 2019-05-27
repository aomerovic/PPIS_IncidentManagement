package com.incidentmng.incidentmng.repository;

import com.incidentmng.incidentmng.model.Services;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends CrudRepository<Services, Long> {
    
}
