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

import com.backend.app.rest.services.CakeService;
import com.backend.app.rest.dto.CakeDTO;
import com.backend.app.rest.models.Cake;

@RestController
@RequestMapping("/api/cakes")
public class CakeController {
  private final CakeService cakeService;

  public CakeController(CakeService cakeService) {
    this.cakeService = cakeService;
  }

  @PostMapping
  public ResponseEntity<Cake> createCake(@RequestBody CakeDTO cake) {
    Cake createdCake = cakeService.addCake(cake);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdCake);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Cake> getCakeById(@PathVariable Long id) {
    Cake cake = cakeService.getCakeById(id);
    if (cake != null) {
      return ResponseEntity.ok(cake);
    } else {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
  }

  @GetMapping
  public ResponseEntity<List<Cake>> getAllCakes() {
    List<Cake> cakes = cakeService.getAllCakes();
    return ResponseEntity.ok(cakes);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteCake(@PathVariable Long id) {
    boolean isDeleted = cakeService.deleteCake(id);
    if (isDeleted) {
      return ResponseEntity.noContent().build();
    }
    return ResponseEntity.notFound().build();
  }

}
