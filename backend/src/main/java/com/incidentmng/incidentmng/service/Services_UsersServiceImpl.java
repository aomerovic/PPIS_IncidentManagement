package com.incidentmng.incidentmng.service;

import com.incidentmng.incidentmng.model.Services_Users;
import com.incidentmng.incidentmng.repository.Services_UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@Service
public class Services_UsersServiceImpl implements Services_UsersService {

    private Services_UsersRepository services_usersRepository;

    @Autowired
    public Services_UsersServiceImpl(Services_UsersRepository services_usersRepository) {
        this.services_usersRepository = services_usersRepository;
    }

    @Override
    public Services_Users save(Services_Users services) {
        return services_usersRepository.save(services);
    }

    @Override
    public Optional<Services_Users> getServices_UsersById(long id) {
        return services_usersRepository.findById(id);
    }

    @Override
    public ArrayList<Services_Users> getAllServices_Users() {
        ArrayList<Services_Users> services_users = new ArrayList<>();
        services_usersRepository.findAll().forEach(services_users::add);
        return services_users;
    }

    @Override
    public Long deleteServices_UsersById(long id) {
        services_usersRepository.deleteById(id);
        return id;
    }

    @Override
    public void updateServicesUsers(long id, Date date) {
        Services_Users services_users = services_usersRepository.findById(id).get();
        services_users.setActive("true");
        services_users.setEnd_date(date);
        services_usersRepository.save(services_users);
    }

}
