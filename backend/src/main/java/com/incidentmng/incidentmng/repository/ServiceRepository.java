package com.incidentmng.incidentmng.repository;

import java.util.ArrayList;
import java.util.Optional;

import com.incidentmng.incidentmng.model.Services;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends CrudRepository<Services, Long> {
    
    @Query(value="SELECT * FROM service WHERE id IN (SELECT service_id FROM services_users WHERE user_id = :id)", nativeQuery = true)
    public ArrayList<Services> getServices(@Param("id") long id);
}
