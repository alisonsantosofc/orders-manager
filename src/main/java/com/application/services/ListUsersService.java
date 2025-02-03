package com.application.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.entities.User;
import com.application.repositories.UsersRepository;

@Service
public class ListUsersService {
  @Autowired
  private UsersRepository usersRepository;

  public List<User> execute() {
    return usersRepository.findAll();
  }
}
