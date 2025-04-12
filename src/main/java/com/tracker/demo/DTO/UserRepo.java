package com.tracker.demo.DTO;

import com.tracker.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo  extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    User findByUsername(String username);
}
