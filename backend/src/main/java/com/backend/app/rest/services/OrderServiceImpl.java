package com.backend.app.rest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.app.rest.dto.OrderDTO;
import com.backend.app.rest.models.Cake;
import com.backend.app.rest.models.CakeOrder;
import com.backend.app.rest.models.Client;

import com.backend.app.rest.repositories.CakeRepo;
import com.backend.app.rest.repositories.ClientRepo;
import com.backend.app.rest.repositories.OrderRepo;

@Service
public class OrderServiceImpl implements OrderService {

  private OrderRepo orderRepo;
  private CakeRepo cakeRepo;
  private ClientRepo clientRepo;

  @Autowired
  public OrderServiceImpl(OrderRepo orderRepo, CakeRepo cakeRepo, ClientRepo clientRepo) {
    this.orderRepo = orderRepo;
    this.cakeRepo = cakeRepo;
    this.clientRepo = clientRepo;
  }

  @Override
  public CakeOrder createOrder(OrderDTO order) {
    Client client = clientRepo.findById(order.getClientId())
        .orElseThrow(() -> new RuntimeException("Client not found with ID: " + order.getClientId()));

    List<Cake> cakes = cakeRepo.findAllById(order.getCakes());
    if (cakes.isEmpty()) {
      throw new RuntimeException("No cakes found for the provided IDs: " + order.getCakes());
    }

    CakeOrder newOrder = CakeOrder.builder()
        .client(client)
        .cakes(cakes)
        .date(order.getDate())
        .typeLivraison(order.getTypeLivraison())
        .adresseLivraison(order.getAdresseLivraison())
        .total(order.getTotal())
        .build();

    return orderRepo.save(newOrder);
  }

  @Override
  public CakeOrder getOrderById(Long id) {
    CakeOrder order = orderRepo.findById(id).orElse(null);
    return order;
  }

  @Override
  public List<CakeOrder> getAllOrders() {
    List<CakeOrder> orders = orderRepo.findAll();
    return orders;
  }

  @Override
  public boolean deleteOrder(Long id) {
    if (orderRepo.existsById(id)) {
      orderRepo.deleteById(id);
      return true;
    }
    return false;
  }

}
