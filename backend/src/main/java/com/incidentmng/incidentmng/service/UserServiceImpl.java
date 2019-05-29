package com.incidentmng.incidentmng.service;

import com.incidentmng.incidentmng.model.Role;
import com.incidentmng.incidentmng.model.Services;
import com.incidentmng.incidentmng.model.User;
import com.incidentmng.incidentmng.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUserById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public ArrayList<User> getAllUsers() {
        ArrayList<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    @Override
    public Long deleteUserById(long id) {
        userRepository.deleteById(id);
        return id;
    }

    @Override
    public User getUser(String username, String pass){
        Optional<User> u = userRepository.getUser(username, pass);
        return u.get();
    }

    @Override
    public String getRola(long id) {
        String r = userRepository.getRola(id);
        return r;
    }

    @Override
    public String getUserId(String username){
        Long l = userRepository.getUserId(username);
        return l.toString();
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }
}
