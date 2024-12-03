package com.backend.app.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.app.rest.models.Client;

public interface ClientRepo extends JpaRepository<Client, Long> {

}
