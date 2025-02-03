package com.application.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;

import com.application.entities.User;

@RestController
@RequestMapping(value = "/users")
public class GetUsersController {
  @GetMapping()
  public ResponseEntity<User> execute() {
    User user = new User(
      1L, 
      "John Doe", 
      "john@email.com", 
      "5581983423876", 
      "1234"
    );
    return ResponseEntity.ok().body(user);
  }
}
