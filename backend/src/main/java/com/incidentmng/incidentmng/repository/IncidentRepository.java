package com.incidentmng.incidentmng.repository;

import com.incidentmng.incidentmng.model.Incident;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncidentRepository extends CrudRepository<Incident, Long> {
}
