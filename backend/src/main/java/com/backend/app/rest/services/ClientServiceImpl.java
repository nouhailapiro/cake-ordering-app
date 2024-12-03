package com.backend.app.rest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.app.rest.repositories.ClientRepo;
import com.backend.app.rest.models.Client;

@Service
public class ClientServiceImpl implements ClientService {
  private final ClientRepo clientRepo;

  @Autowired
  public ClientServiceImpl(ClientRepo clientRepo) {
    this.clientRepo = clientRepo;
  }

  @Override
  public Client getClientById(Long id) {
    return clientRepo.findById(id).orElse(null);
  }

  @Override
  public List<Client> getAllClients() {
    return clientRepo.findAll();
  }

  @Override
  public boolean deleteClientById(Long id) {
    if (clientRepo.existsById(id)) {
      clientRepo.deleteById(id);
      return true;
    }
    return false;
  }
}
