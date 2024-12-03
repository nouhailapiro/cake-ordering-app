package com.backend.app.rest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.backend.app.rest.repositories.ClientRepo;
import com.backend.app.rest.repositories.PatissierRepo;
import com.backend.app.rest.repositories.UserRepo;
import com.backend.app.rest.models.Client;
import com.backend.app.rest.models.Patissier;
import com.backend.app.rest.models.User;
import com.backend.app.rest.models.enums.Role;

@Service
public class UserServiceImpl implements UserService {

  private UserRepo userRepo;
  private ClientRepo clientRepo;
  private PatissierRepo patissierRepo;
  private PasswordEncoder passwordEncoder;

  @Autowired
  public UserServiceImpl(UserRepo userRepo, PasswordEncoder passwordEncoder, ClientRepo clientRepo,
      PatissierRepo patissierRepo) {
    this.userRepo = userRepo;
    this.clientRepo = clientRepo;
    this.patissierRepo = patissierRepo;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public User createUser(User user) {
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    userRepo.save(user);
    if (user.getRole() == Role.CLIENT) {
      Client client = new Client();
      client.setUser(user);
      clientRepo.save(client);
    } else {
      Patissier patissier = new Patissier();
      patissier.setUser(user);
      patissierRepo.save(patissier);
    }
    return user;
  }

  @Override
  public List<User> getAllUsers() {
    return userRepo.findAll();
  }

  @Override
  public boolean deleteUser(Long id) {
    if (userRepo.existsById(id)) {
      userRepo.deleteById(id);
      return true;
    }
    return false;
  }

  @Override
  public User getUserById(Long id) {
    return userRepo.findById(id).orElse(null);
  }

}
