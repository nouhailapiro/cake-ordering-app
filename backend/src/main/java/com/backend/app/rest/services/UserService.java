package com.backend.app.rest.services;

import java.util.List;

import com.backend.app.rest.models.User;

public interface UserService {
  public User createUser(User user);

  public boolean deleteUser(Long id);

  public List<User> getAllUsers();

  public User getUserById(Long id);
}
