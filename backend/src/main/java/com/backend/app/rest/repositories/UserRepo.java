package com.backend.app.rest.repositories;

import com.backend.app.rest.models.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
  Optional<User> findByEmail(String email);
}
