package com.incidentmng.incidentmng.repository;

import com.incidentmng.incidentmng.model.Services_Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Services_UsersRepository extends CrudRepository<Services_Users, Long> {
}
