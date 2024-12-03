package com.backend.app.rest.services;

import com.backend.app.rest.repositories.CakeRepo;
import com.backend.app.rest.repositories.PatissierRepo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.app.rest.dto.CakeDTO;
import com.backend.app.rest.models.Cake;
import com.backend.app.rest.models.Patissier;

@Service
public class CakeServiceImpl implements CakeService {
  private CakeRepo cakeRepo;
  private PatissierRepo patissierRepo;

  @Autowired
  public CakeServiceImpl(CakeRepo cakeRepo, PatissierRepo patissierRepo) {
    this.cakeRepo = cakeRepo;
    this.patissierRepo = patissierRepo;
  }

  @Override
  public Cake addCake(CakeDTO cakeDTO) {
    Patissier patissier = patissierRepo.findById(cakeDTO.getPatissierId())
        .orElseThrow(() -> new RuntimeException("Patissier not found "));
    Cake cake = Cake.builder()
        .nom(cakeDTO.getNom())
        .description(cakeDTO.getDescription())
        .image(cakeDTO.getImage())
        .prix(cakeDTO.getPrix())
        .patissier(patissier)
        .build();
    cakeRepo.save(cake);
    return cake;
  }

  @Override
  public Cake getCakeById(Long id) {
    Cake cake = cakeRepo.findById(id).orElse(null);
    return cake;
  }

  @Override
  public List<Cake> getAllCakes() {
    return cakeRepo.findAll();
  }

  @Override
  public boolean deleteCake(Long id) {
    if (cakeRepo.existsById(id)) {
      cakeRepo.deleteById(id);
      return true;
    }
    return false;
  }

}
