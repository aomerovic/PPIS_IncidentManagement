package com.incidentmng.incidentmng.repository;

import com.incidentmng.incidentmng.model.Status;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends CrudRepository<Status, Long> {
}
