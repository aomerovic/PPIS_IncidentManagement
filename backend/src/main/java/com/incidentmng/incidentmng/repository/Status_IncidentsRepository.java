package com.incidentmng.incidentmng.repository;

import com.incidentmng.incidentmng.model.Status_Incidents;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Status_IncidentsRepository extends CrudRepository<Status_Incidents, Long> {
}
