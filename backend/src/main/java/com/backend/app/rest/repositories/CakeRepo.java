package com.backend.app.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.app.rest.models.Cake;

public interface CakeRepo extends JpaRepository<Cake, Long> {

}
