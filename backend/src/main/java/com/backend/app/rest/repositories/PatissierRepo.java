package com.backend.app.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.app.rest.models.Patissier;

public interface PatissierRepo extends JpaRepository<Patissier, Long> {

}
