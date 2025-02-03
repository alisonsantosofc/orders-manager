package com.application.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.application.entities.Order;
import com.application.services.ListOrdersService;

@RestController
@RequestMapping(value = "/Orders")
public class ListOrdersController {
  @Autowired
  private ListOrdersService listOrdersService;

  @GetMapping()
  public ResponseEntity<List<Order>> handle() {
    List<Order> orders = listOrdersService.execute();

    return ResponseEntity.ok().body(orders);
  }
}
