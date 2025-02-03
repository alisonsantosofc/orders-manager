package com.application.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.application.entities.User;
import com.application.services.ListUsersService;

@RestController
@RequestMapping(value = "/users")
public class ListUsersController {
  @Autowired
  private ListUsersService listUsersService;

  @GetMapping()
  public ResponseEntity<List<User>> handle() {
    List<User> users = listUsersService.execute();

    return ResponseEntity.ok().body(users);
  }
}
