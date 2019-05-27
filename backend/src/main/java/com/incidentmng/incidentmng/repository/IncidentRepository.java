package com.incidentmng.incidentmng.repository;

import java.util.ArrayList;

import com.incidentmng.incidentmng.model.Incident;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IncidentRepository extends CrudRepository<Incident, Long> {

    @Query(value="SELECT * FROM incident WHERE user_id = :id", nativeQuery = true)
    public ArrayList<Incident> getIncidentsFromUser(@Param("id") long id);
}
