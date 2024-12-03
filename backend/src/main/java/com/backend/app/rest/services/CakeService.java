package com.backend.app.rest.services;

import java.util.List;

import com.backend.app.rest.dto.CakeDTO;
import com.backend.app.rest.models.Cake;

public interface CakeService {
  public Cake addCake(CakeDTO cakeDTO);

  public Cake getCakeById(Long id);

  public List<Cake> getAllCakes();

  public boolean deleteCake(Long id);

}
