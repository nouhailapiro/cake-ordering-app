package com.backend.app.rest.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.app.rest.dto.OrderDTO;
import com.backend.app.rest.models.CakeOrder;
import com.backend.app.rest.services.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
  private final OrderService orderService;

  public OrderController(OrderService orderService) {
    this.orderService = orderService;
  }

  @PostMapping
  public ResponseEntity<CakeOrder> createOrder(@RequestBody OrderDTO order) {
    CakeOrder savedOrder = orderService.createOrder(order);
    return ResponseEntity.status(HttpStatus.CREATED).body(savedOrder);
  }

  @GetMapping("/{id}")
  public ResponseEntity<CakeOrder> getOrderById(@PathVariable Long id) {
    CakeOrder order = orderService.getOrderById(id);
    if (order != null) {
      return ResponseEntity.ok(order);
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
  }

  @GetMapping
  public ResponseEntity<List<CakeOrder>> getAllOrders() {
    List<CakeOrder> orders = orderService.getAllOrders();
    return ResponseEntity.ok(orders);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
    boolean isDeleted = orderService.deleteOrder(id);
    if (isDeleted) {
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.notFound().build();
  }
}
