package com.incidentmng.incidentmng.repository;

import com.incidentmng.incidentmng.model.Services_Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;

@Repository
public interface Services_UsersRepository extends CrudRepository<Services_Users, Long> {
    @Query(value = "SELECT * FROM services_users WHERE service_id=:id AND user_id=:user_id", nativeQuery = true)
    public Services_Users getServices_UsersForUserAndService(@Param("id") long id, @Param("user_id") long user_id);

}
