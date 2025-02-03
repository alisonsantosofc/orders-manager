package com.application.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.entities.Order;
import com.application.repositories.OrdersRepository;

@Service
public class ListOrdersService {
  @Autowired
  private OrdersRepository ordersRepository;

  public List<Order> execute() {
    return ordersRepository.findAll();
  }
}
