package com.tracker.demo.services;

import com.tracker.demo.DTO.UserRepo;
import com.tracker.demo.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> getUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public User saveUser(User user) {
        return userRepo.save(user);
    }

    @Transactional
    @Override
    public void deleteUser(User user) {
        userRepo.delete(user);
    }

    @Override
    public Optional<User> getUserByEmail(String Email) {
        return userRepo.findByEmail(Email);
    }

    @Override
    public Optional<User> authenticate(String username, String password) {
        Optional<User> userOptional = Optional.ofNullable(userRepo.findByUsername(username));
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (passwordEncoder.matches(password, user.getPasswordHash())) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    @Override
    public User save(User user) {
        user.setPasswordHash(passwordEncoder.encode(user.getPasswordHash()));
        return userRepo.save(user);
    }
}
