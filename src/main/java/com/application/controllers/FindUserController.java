package com.application.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.application.entities.User;
import com.application.services.FindUserService;

@RestController
@RequestMapping(value = "/users")
public class FindUserController {
  @Autowired
  private FindUserService findUserService;

  @GetMapping(value = "/{id}")
  public ResponseEntity<User> handle(@PathVariable Long id) {
    User user = findUserService.execute(id);

    return ResponseEntity.ok().body(user);
  }
}
