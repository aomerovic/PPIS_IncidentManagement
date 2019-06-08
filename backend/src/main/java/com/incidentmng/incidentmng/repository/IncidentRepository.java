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

    @Query(value = "SELECT count(*) from incident WHERE service_id=:id", nativeQuery = true)
    public long getNumberOfIncidents(@Param("id") long id);
    
    @Query(value = "SELECT COUNT(*) FROM incident where service_id=:id and id in (SELECT incident_id from status_incidents WHERE status_id = 1)", nativeQuery=true)
    public long getNuberOfSolvedIncidents(@Param("id") long id);

    @Query(value = "SELECT * FROM incident WHERE handle_id=:id", nativeQuery = true)
    public ArrayList<Incident> getAllIncidentsForUser(@Param("id") long id);

}
