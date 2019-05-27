package com.incidentmng.incidentmng.repository;

import com.incidentmng.incidentmng.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

}
