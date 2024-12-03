package com.backend.app.rest.services;

import java.util.List;

import com.backend.app.rest.dto.OrderDTO;
import com.backend.app.rest.models.CakeOrder;

public interface OrderService {
  public CakeOrder createOrder(OrderDTO order);

  public CakeOrder getOrderById(Long id);

  public List<CakeOrder> getAllOrders();

  public boolean deleteOrder(Long id);
}
