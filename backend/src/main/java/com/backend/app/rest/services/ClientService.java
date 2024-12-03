package com.backend.app.rest.services;

import java.util.List;

import com.backend.app.rest.models.Client;

public interface ClientService {
  public Client getClientById(Long id);

  public List<Client> getAllClients();

  public boolean deleteClientById(Long id);
}
