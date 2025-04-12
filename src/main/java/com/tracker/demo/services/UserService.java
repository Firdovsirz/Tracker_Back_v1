package com.tracker.demo.services;

import com.tracker.demo.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getUsers();
    User getUserByUsername(String username);
    User saveUser(User user);
    void deleteUser(User user);
    Optional<User> getUserByEmail(String Email);
    Optional<User> authenticate(String username, String password);
    User save(User user);
}
