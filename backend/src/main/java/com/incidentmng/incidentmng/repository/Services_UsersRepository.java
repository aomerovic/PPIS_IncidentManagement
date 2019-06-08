package com.incidentmng.incidentmng.repository;

import com.incidentmng.incidentmng.model.Services_Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface Services_UsersRepository extends CrudRepository<Services_Users, Long> {
}
