package com.burakyildiz.springboothomework4.repository;

import com.burakyildiz.springboothomework4.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
