package com.incidentmng.incidentmng.repository;

import com.incidentmng.incidentmng.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
