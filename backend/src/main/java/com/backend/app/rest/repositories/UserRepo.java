package com.backend.app.rest.repositories;

import com.backend.app.rest.models.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {

}
