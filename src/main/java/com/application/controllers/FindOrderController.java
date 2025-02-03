package com.application.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.application.entities.Order;
import com.application.services.FindOrderService;

@RestController
@RequestMapping(value = "/orders")
public class FindOrderController {
  @Autowired
  private FindOrderService findOrderService;

  @GetMapping(value = "/{id}")
  public ResponseEntity<Order> handle(@PathVariable Long id) {
    Order order = findOrderService.execute(id);

    return ResponseEntity.ok().body(order);
  }
}
