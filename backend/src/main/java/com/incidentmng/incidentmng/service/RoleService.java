package com.incidentmng.incidentmng.service;

import com.incidentmng.incidentmng.model.Role;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public interface RoleService {
    Role save(Role role);

    Optional<Role> getRoleById(long id);

    ArrayList<Role> getAllRoles();

    Long deleteRoleById(long id);
}
