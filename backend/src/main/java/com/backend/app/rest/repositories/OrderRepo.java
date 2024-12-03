package com.backend.app.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.app.rest.models.CakeOrder;

public interface OrderRepo extends JpaRepository<CakeOrder, Long> {

}
