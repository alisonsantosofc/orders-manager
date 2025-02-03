package com.application.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.entities.User;
import com.application.repositories.UsersRepository;

@Service
public class FindUserService {
  @Autowired
  private UsersRepository usersRepository;

  public User execute(Long id) {
    Optional<User> user = usersRepository.findById(id);
    
    return user.get();
  }
}
