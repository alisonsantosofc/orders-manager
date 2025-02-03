package com.application.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.entities.Order;
import com.application.repositories.OrdersRepository;

@Service
public class FindOrderService {
  @Autowired
  private OrdersRepository ordersRepository;

  public Order execute(Long id) {
    Optional<Order> order = ordersRepository.findById(id);
    
    return order.get();
  }
}
