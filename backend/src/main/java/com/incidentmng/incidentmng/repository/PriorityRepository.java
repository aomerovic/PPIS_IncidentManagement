package com.incidentmng.incidentmng.repository;

import com.incidentmng.incidentmng.model.Priority;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriorityRepository extends CrudRepository<Priority, Long> {
}
