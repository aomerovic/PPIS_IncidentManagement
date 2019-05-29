package com.incidentmng.incidentmng.repository;

import java.util.Optional;

import com.incidentmng.incidentmng.model.Services;
import com.incidentmng.incidentmng.model.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query(value="SELECT * FROM user WHERE username=:username and password=:pass", nativeQuery = true)
    public Optional<User> getUser(@Param("username")String username,@Param("pass")String password);
    
    @Query(value="SELECT id FROM user WHERE username=:username", nativeQuery = true)
    public Long getUserId(@Param("username") String username);

    @Query(value="SELECT role_name FROM role WHERE id = (SELECT role_id FROM user WHERE id=:id)", nativeQuery = true)
    public String getRola(@Param("id") long id);

    @Query(value = "SELECT * FROM user WHERE username=:username", nativeQuery = true)
    User getUserByUsername(@Param("username") String username);
}
